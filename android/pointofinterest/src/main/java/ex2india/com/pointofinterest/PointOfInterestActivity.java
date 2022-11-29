package ex2india.com.pointofinterest;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.bhi.commonlib.SessionManager;
import com.bhi.commonlib.app.ProcessUtil;
import com.bhi.commonlib.nearByPlaces.NearByRadius;
import com.bhi.commonlib.nearByPlaces.model.NearByPlace;
import com.bhi.commonlib.nearByPlaces.model.NearByPlaceResponse;
import com.bhi.commonlib.util.MyToast;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.ar.core.Frame;
import com.google.ar.core.Plane;
import com.google.ar.core.Session;
import com.google.ar.core.TrackingState;
import com.google.ar.core.exceptions.CameraNotAvailableException;
import com.google.ar.core.exceptions.UnavailableException;
import com.google.ar.sceneform.ArSceneView;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.myvolley.models.ApiError;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import ex2india.com.pointofinterest.filter.POIFilterDialog;
import ex2india.com.pointofinterest.filter.POIFilterListener;
import ex2india.com.pointofinterest.nearByPlacesApi.GetNearByPlaceCallback;
import ex2india.com.pointofinterest.nearByPlacesApi.NearByPlacesApiHelper;
import ex2india.com.pointofinterest.nearByPlacesApi.PoiCategory;
import ex2india.com.pointofinterest.radius.Radius;
import ex2india.com.pointofinterest.utils.POIUtil;
import timber.log.Timber;
import uk.co.appoly.arcorelocation.LocationMarker;
import uk.co.appoly.arcorelocation.LocationScene;
import uk.co.appoly.arcorelocation.utils.ARLocationPermissionHelper;

public class PointOfInterestActivity extends AppCompatActivity
        implements POIFilterListener, View.OnClickListener {

    public static final String KEY_TINT_COLOR = "tint_color";

    private ArSceneView arSceneView;
    private POIFilterDialog poiFilterDialog;
    private Dialog mProgressDialog;
    private TextView tvDescription;
    private CheckBox cbDontShowAgain;
    private FusedLocationProviderClient fusedLocationClient;

    private int tintColor;
    private boolean isInResumeState;

    /**
     * Callback to listen to location related events.
     */
    private final LocationCallback mLocationCallback = new LocationCallback() {

        @Override
        public void onLocationResult(@NonNull LocationResult locationResult) {
            super.onLocationResult(locationResult);
            Location location = locationResult.getLastLocation();
            Timber.d("new Location ->" + location.getLatitude() + " " + location.getLongitude());
            locationReceived = true;
            currentLocation = location;

            if (locationScene == null) {
                initialiseLocationScene();
            }

            //Note that, once the location is fetched we're stopping further location updates.
            //  mLocationManager.removeUpdates(this);
            fusedLocationClient.removeLocationUpdates(this);
        }
    };

    private PopupWindow popupWindow;
    private View backgroundView;

    private Radius selectedRadius;
    private PoiCategory selectedCategory;
    private final List<NearByPlace> placesList = new ArrayList<>();
    private List<PoiCategory> categoryList;
    private List<Radius> radiusList;
    private boolean hasFinishedLoading = false;
    private boolean locationReceived = false;
    private boolean installRequested;
    private Boolean findPlacesAPICalled = false;
    private Boolean annotationSet = false;
    private LocationScene locationScene;
    private Location currentLocation;
    private ImageView helpIV;
    private boolean isCalledForFirstTime = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poi_activity);

        tintColor = getIntent().getIntExtra(KEY_TINT_COLOR, Color.BLACK);

        ImageView filterIV = findViewById(R.id.iv_filter);
        arSceneView = findViewById(R.id.ar_scene_view);
        ImageView closeScreenIV = findViewById(R.id.iv_close_screen);
        helpIV = findViewById(R.id.iv_help);
        backgroundView = findViewById(R.id.view_background);
        tvDescription = findViewById(R.id.tv_description);
        ImageView refreshPoiIV = findViewById(R.id.iv_refresh_poi);

        //Adding POI categories
        categoryList = new ArrayList<>(Arrays.asList(PoiCategory.values()));
        Collections.sort(categoryList, (o1, o2) -> o1.getNhnCategoryName().compareTo(o2.getNhnCategoryName()));
        selectedCategory = categoryList.get(0);

        //Adding POI radii
        int[] radii = getResources().getIntArray(R.array.poi_radii);
        radiusList = new ArrayList<>();

        for (int radius : radii) {
            String title = String.format(getResources().getQuantityString(R.plurals.radius_miles, radius), radius);
            radiusList.add(new Radius(radius, title));
        }

        selectedRadius = radiusList.get(2);

        initializeARScene();

        //Requesting CAMERA & location permissions which are required for ARCore-Location.
        ARLocationPermissionHelper.requestPermission(this);

        //Configuring Tooltip dialog (Popup Window)
        setupPOITooltipDialog();

        helpIV.setOnClickListener(this);
        closeScreenIV.setOnClickListener(this);
        filterIV.setOnClickListener(this);
        refreshPoiIV.setOnClickListener(this);
    }


    @SuppressLint("ClickableViewAccessibility")
    private void setupPOITooltipDialog() {
        View popupWindowView = View.inflate(this, R.layout.layout_poi_app_popup_window, null);
        TextView gotItTV = popupWindowView.findViewById(R.id.tv_got_it);
        cbDontShowAgain = popupWindowView.findViewById(R.id.cb_dont_show_again);

        new Thread(() -> {
            final boolean isPOISeen = SessionManager.INSTANCE.isPointOfInterestARHelperTextSeen(PointOfInterestActivity.this);

            runOnUiThread(() -> cbDontShowAgain.setChecked(isPOISeen));
        }).start();

        gotItTV.setOnClickListener(v -> {
            SessionManager.INSTANCE.setPointOfInterestARHelperTextSeen(this, cbDontShowAgain.isChecked());
            toggleTooltip();
        });

        popupWindow = new PopupWindow();
        popupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setContentView(popupWindowView);

        if (!SessionManager.INSTANCE.isPointOfInterestARHelperTextSeen(this)) {
            (new Handler(Looper.getMainLooper())).postDelayed(this::toggleTooltip, 800);
        }

        backgroundView.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN && popupWindow.isShowing()) {
                toggleTooltip();
            }
            return false;
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_close_screen) {
            finish();
        } else if (v.getId() == R.id.iv_help) {
            toggleTooltip();
        } else if (v.getId() == R.id.iv_filter) {
            toggleFilter();
        } else if (v.getId() == R.id.iv_refresh_poi) {
            reloadPOIs();
        }
    }


    private void toggleTooltip() {
        if (!isInResumeState) {
            return;
        }

        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
        } else {
            try {
                //At very rare case, popupWindow.showAsDropDown() statement is seen causing a crash.
                //Error is: "Fatal Exception: android.view.WindowManager$BadTokenException). Unable to add window -- token null is not valid; is your activity running?"
                //Though, I've added a check for activity running using variable "isInResumeState" but app gets crashed due to popupWindow.showAsDropDown()
                //in rare scenarios. So, to handle it, I'm adding this line in try-catch block to avoid crash in such a strange scenario.
                popupWindow.showAsDropDown(helpIV, 0, 0);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }


    @TargetApi(Build.VERSION_CODES.N)
    private void initializeARScene() {
        CompletableFuture<ViewRenderable> poiLayoutCompletableFuture =
                ViewRenderable.builder()
                        .setView(this, R.layout.item_poi_annotation)
                        .build();

        CompletableFuture.allOf(
                poiLayoutCompletableFuture)
                .handle(
                        (notUsed, throwable) -> {
                            if (throwable != null) {
                                throwable.printStackTrace();
                                MyToast.INSTANCE.makeText(this, getString(R.string.msg_something_went_wrong));
                                return null;
                            }

                            try {
                                poiLayoutCompletableFuture.get();
                                hasFinishedLoading = true;
                            } catch (InterruptedException | ExecutionException ex) {
                                ex.printStackTrace();
                                MyToast.INSTANCE.makeText(this, getString(R.string.msg_something_went_wrong));
                            }

                            return null;
                        });

        arSceneView.getScene().addOnUpdateListener(frameTime -> {
            Frame frame = arSceneView.getArFrame();
            if (frame == null) {
                return;
            }

            if (frame.getCamera().getTrackingState() != TrackingState.TRACKING) {
                return;
            }

            for (Plane plane : frame.getUpdatedTrackables(Plane.class)) {
                if (plane.getTrackingState() == TrackingState.TRACKING) {
                    if (locationReceived && isCalledForFirstTime) {
                        dismissProgressDialog();
                        reloadPOIs();
                    }
                    onARSceneUpdate();
                    break;//TODO: Is having break condition here OK? Ask from Jagveer.
                }
            }

        });

    }

    @Override
    public void onCategorySelected(@NotNull PoiCategory category) {
        selectedCategory = category;
        reloadPOIs();
    }

    @Override
    public void onRadiusSelected(@NotNull Radius radiusMiles) {
        selectedRadius = radiusMiles;
        poiFilterDialog.dismiss();

        reloadPOIs();
    }

    private void reloadPOIs() {
        if (!placesList.isEmpty()) {
            clearAllPOIs();
        }

        findPlacesAPICalled = false;

        String fetchingMessage = String.format(getString(R.string.msg_fetching_point_of_interests), selectedCategory.getNhnCategoryName(),
                selectedRadius.getRadiusMiles());
        showDescription(fetchingMessage);
        showProgressDialog();

        requestNearByLocations();
    }


    private void onARSceneUpdate() {
        if (!hasFinishedLoading) {
            return;
        }

        if (!locationReceived) {
            return;
        }

        if (locationScene == null) {
            // If our locationScene object hasn't been setup yet, this is a good time to do it
            // We know that here, the AR components have been initiated.
            initialiseLocationScene();
        }

        if (!findPlacesAPICalled) {
            return;
        }

        if (!annotationSet) {
            //Rendering all POIs
            PoiGroupRenderer poiGroupRenderer = new PoiGroupRenderer(PointOfInterestActivity.this, locationScene);
            poiGroupRenderer.render(placesList, () -> {
                String description = getResources().getQuantityString(R.plurals.poi_type_and_radius,
                        selectedRadius.getRadiusMiles(), selectedCategory.getNhnCategoryName(), selectedRadius.getRadiusMiles());
                showDescription(description);
                dismissProgressDialog();
            });
        }

        Frame frame = arSceneView.getArFrame();
        if (frame == null) {
            return;
        }

        if (frame.getCamera().getTrackingState() != TrackingState.TRACKING) {
            return;
        }

        if (locationScene != null) {
            locationScene.processFrame(frame);
        }

        if (placesList.size() > 0) {
            annotationSet = true;
        }
    }


    /**
     * Make sure we call locationScene.resume();
     */
    @Override
    protected void onResume() {
        super.onResume();
        isInResumeState = true;

        if (locationScene != null) {
            locationScene.resume();
        }

        if (arSceneView.getSession() == null) {
            // If the session wasn't created yet, don't resume rendering.
            // This can happen if ARCore needs to be updated or permissions are not granted yet.
            try {
                Session session = POIUtil.createArSession(this, installRequested);
                if (session == null) {
                    installRequested = ARLocationPermissionHelper.hasPermission(this);
                    return;
                } else {
                    arSceneView.setupSession(session);
                }
            } catch (UnavailableException e) {
                e.printStackTrace();
                MyToast.INSTANCE.makeText(this, R.string.msg_something_went_wrong);
            }
        }

        try {
            arSceneView.resume();
        } catch (CameraNotAvailableException ex) {
            ex.printStackTrace();
            MyToast.INSTANCE.makeText(this, getString(R.string.msg_something_went_wrong));
            finish();
        }
    }

    /**
     * Make sure we call locationScene.pause();
     */
    @Override
    public void onPause() {
        super.onPause();
        isInResumeState = false;

        if (locationScene != null) {
            locationScene.pause();
        }

        arSceneView.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dismissProgressDialog();
        if (arSceneView != null) {
            arSceneView.destroy();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] results) {
        super.onRequestPermissionsResult(requestCode, permissions, results);
        if (!ARLocationPermissionHelper.hasPermission(this)) {
            if (!ARLocationPermissionHelper.shouldShowRequestPermissionRationale(this)) {
                // Permission denied with checking "Do not ask again".
                ARLocationPermissionHelper.launchPermissionSettings(this);
            } else {
                MyToast.INSTANCE.makeText(this, R.string.msg_permission_rejection_for_poi, Toast.LENGTH_LONG);
            }
            finish();
        } else {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                MyToast.INSTANCE.makeText(this, R.string.msg_permission_rejection_for_poi, Toast.LENGTH_LONG);
                return;
            }

            //Requesting current location
            showProgressDialog(getString(R.string.msg_detecting_your_location));
            showDescription(null);

            fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
            fusedLocationClient.requestLocationUpdates(new LocationRequest(), mLocationCallback, Looper.myLooper());

        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        hideSystemUI(hasFocus);
    }

    void initialiseLocationScene() {
        locationScene = new LocationScene(this, this, arSceneView);
    }

    void clearAllPOIs() {
        if (locationScene == null)
            return;

        placesList.clear();
        for (LocationMarker marker : locationScene.mLocationMarkers) {
            marker.node.setParent(null);
        }
        locationScene.mLocationMarkers.clear();
    }

    private void toggleFilter() {
        if (null == poiFilterDialog || !poiFilterDialog.isShowing()) {
            poiFilterDialog = POIFilterDialog.newInstance(this,
                    this,
                    categoryList,
                    radiusList,
                    selectedRadius,
                    selectedCategory);
            poiFilterDialog.show();
        } else {
            poiFilterDialog.dismiss();
            poiFilterDialog = null;
        }
    }

    private NearByRadius getNearByRadius() {
        int radius = selectedRadius.getRadiusMiles();
        for (NearByRadius nearByRadius : NearByRadius.values()) {
            if (nearByRadius.getMiles() == radius) {
                return nearByRadius;
            }
        }
        return NearByRadius.ONE;
    }

    /**
     * Requesting nearby point of interests to Google place API.
     */
    private void requestNearByLocations() {

        if (findPlacesAPICalled) {
            return;
        }
        findPlacesAPICalled = true;
        isCalledForFirstTime = false;

        NearByPlacesApiHelper.INSTANCE.getNearByPlaces(currentLocation.getLatitude(),
                currentLocation.getLongitude(), selectedCategory.getGooglePlaceCategoryName(), getNearByRadius(),
                new GetNearByPlaceCallback() {
                    @Override
                    public void onNearByPlaceReceiveSuccess(@NotNull NearByPlaceResponse nearByPlaceResponse) {
                        dismissProgressDialog();
                        showDescription(null);
                        if (nearByPlaceResponse.getResult() == null || nearByPlaceResponse.getResult().isEmpty()) {
                            MyToast.INSTANCE.makeText(PointOfInterestActivity.this, R.string.msg_no_poi_result);
                        } else {
                            clearAllPOIs();
                            placesList.addAll(nearByPlaceResponse.getResult());
                            annotationSet = false;
                            onARSceneUpdate();
                        }
                    }

                    @Override
                    public void onNearByPlaceReceiveFailure(@NotNull Exception exception) {
                        exception.printStackTrace();
                        dismissProgressDialog();
                        showDescription(null);

                        if (exception instanceof ApiError) {
                            MyToast.INSTANCE.makeText(PointOfInterestActivity.this, ApiErrorMessage.INSTANCE.getErrorMessageRes((ApiError) exception));
                        } else {
                            MyToast.INSTANCE.makeText(PointOfInterestActivity.this, getString(R.string.msg_something_went_wrong));
                        }
                    }
                });
    }

    private void showDescription(String description) {
        if (TextUtils.isEmpty(description)) {
            tvDescription.setVisibility(View.GONE);
        } else {
            tvDescription.setVisibility(View.VISIBLE);
            tvDescription.setText(description);
        }
    }

    /**
     * Shows a progress dialog
     */
    private void showProgressDialog(String message) {
        if (null != mProgressDialog) {
            mProgressDialog.dismiss();
        }

        ProgressDialog progressDialog = new ProgressDialog(this) {

            @Override
            public void onWindowFocusChanged(boolean hasFocus) {
                super.onWindowFocusChanged(hasFocus);
                hideSystemUI(hasFocus);
            }
        };

        Drawable drawable = new ProgressBar(this).getIndeterminateDrawable().mutate();
        drawable.setColorFilter(tintColor, PorterDuff.Mode.SRC_IN);
        progressDialog.setIndeterminateDrawable(drawable);
        progressDialog.setCancelable(true);
        progressDialog.setCanceledOnTouchOutside(false);

        if (null != message) {
            progressDialog.setMessage(message);
        }

        progressDialog.setOnCancelListener(dialog -> finish());

        mProgressDialog = progressDialog;
        progressDialog.show();
    }


    private void showProgressDialog() {
        if (null != mProgressDialog) {
            mProgressDialog.dismiss();
        }

        ProgressBar progressBar = new ProgressBar(this);
        progressBar.setBackgroundColor(Color.TRANSPARENT);
        progressBar.setDrawingCacheBackgroundColor(Color.TRANSPARENT);
        progressBar.getIndeterminateDrawable().setColorFilter(tintColor, PorterDuff.Mode.MULTIPLY);

        mProgressDialog = new Dialog(this, R.style.TransparentDialog) {

            @Override
            public void onWindowFocusChanged(boolean hasFocus) {
                super.onWindowFocusChanged(hasFocus);
                hideSystemUI(hasFocus);
            }
        };

        if (mProgressDialog.getWindow() != null) {
            mProgressDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            mProgressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }

        mProgressDialog.setContentView(progressBar);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.show();
    }


    private void dismissProgressDialog() {
        if (null != mProgressDialog) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    private void hideSystemUI(Boolean windowHasFocus) {
        if (windowHasFocus) {
            Window window = getWindow();

            if (null != window) {
                window.getDecorView().setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            }
        }
    }
}