package ex2india.com.furnituredrop;


import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.PixelCopy;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;

import com.bhi.commonlib.SessionManager;
import com.bhi.commonlib.app.ProcessUtil;
import com.bhi.commonlib.util.BaseActivity;
import com.bhi.commonlib.util.ImageFileUtil;
import com.bhi.commonlib.util.MyToast;
import com.google.ar.core.Anchor;
import com.google.ar.core.Frame;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.core.Plane.Type;
import com.google.ar.core.TrackingState;
import com.google.ar.core.exceptions.CameraNotAvailableException;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.ArSceneView;
import com.google.ar.sceneform.FrameTime;
import com.google.ar.sceneform.HitTestResult;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.math.Quaternion;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.Renderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import ex2india.com.furnituredrop.dropdialog.FurnitureDropDialog;
import ex2india.com.furnituredrop.dropdialog.OnFurnitureSelectionListener;

public class FurnitureDropActivity extends BaseActivity
        implements OnFurnitureSelectionListener {

    private static final int TOTAL_FURNITURE_SET_COUNT = 6;
    private static final String FURNITURE_SET_1 = "furniture_set_1.sfb";
    private static final String FURNITURE_SET_2 = "furniture_set_2.sfb";
    private static final String FURNITURE_SET_3 = "furniture_set_3.sfb";
    private static final String FURNITURE_SET_4 = "furniture_set_4.sfb";
    private static final String FURNITURE_SET_5 = "furniture_set_5.sfb";
    private static final String FURNITURE_SET_6 = "furniture_set_6.sfb";

    private static final int RC_SCREENSHOT_PERMISSIONS = 1;
    private static final String POINTER_NODE = "pointer_node";

    private ArFragment arFragment;
    private final Uri[] furnitureSetRenderables = new Uri[TOTAL_FURNITURE_SET_COUNT];
    private ViewRenderable deleteRenderable;
    private FurnitureDropDialog furnitureDropDialog;
    private ImageView deleteFurnitureIV;
    private ImageView clearIV;
    private Node currentNode;
    private boolean permissionRequested;
    private ImageView helpIV;
    private ImageView addFurnitureIV;
    private ImageView screenshotIV;
    private PopupWindow popupWindow;
    private CheckBox cbDontShowAgain;

    private GestureDetector trackableGestureDetector;
    private ArrayList<TransformableNode> nodes;
    private boolean hasFinishedLoading = false;
    private final boolean errorOccurred = false;
    private boolean isInResumeStage = false;
    private Dialog progressDialog;


    @SuppressLint("ClickableViewAccessibility")
    @SuppressWarnings({"AndroidApiChecker", "FutureReturnValueIgnored"})

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("in oncreate1","yes");
        Log.d("out oncreate","yes");
        setContentView(R.layout.activity_furniture_drop);
        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.ux_fragment);
        View backgroundView = findViewById(R.id.view_background);
        deleteFurnitureIV = findViewById(R.id.iv_delete_furniture);
        clearIV = findViewById(R.id.iv_clear);
        helpIV = findViewById(R.id.iv_help);
        ImageView closeScreenIV = findViewById(R.id.iv_close_screen);
        addFurnitureIV = findViewById(R.id.iv_add_furniture);
        screenshotIV = findViewById(R.id.iv_screenshot);

        nodes = new ArrayList<>();

        // Build all the furniture models.
        loadARModels();

        arFragment.getArSceneView().getScene().addOnPeekTouchListener(this::handleOnTouch);

        ArSceneView arSceneView = arFragment.getArSceneView();
        arSceneView.getScene().addOnUpdateListener(frameTime -> onArSceneViewUpdate(arSceneView, frameTime));

        trackableGestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            public boolean onSingleTapUp(MotionEvent e) {
                hideFurnitureDropDialog();
                return true;
            }

            public boolean onDown(MotionEvent e) {
                return true;
            }
        });

        //Configuring Tooltip dialog (Popup Window)
        View popupWindowView = LayoutInflater.from(this).inflate(R.layout.layout_furniture_drop_popup_window, null);
        TextView gotItTV = popupWindowView.findViewById(R.id.tv_got_it);
        cbDontShowAgain = popupWindowView.findViewById(R.id.cb_dont_show_again);
        cbDontShowAgain.setChecked(SessionManager.INSTANCE.isFurnitureARHelperTextSeen(this));

        gotItTV.setOnClickListener(v -> {
            SessionManager.INSTANCE.setFurnitureARHelperTextSeen(this, cbDontShowAgain.isChecked());
            toggleTooltip();
        });

        popupWindow = new PopupWindow();
        popupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setContentView(popupWindowView);

        if (!SessionManager.INSTANCE.isFurnitureARHelperTextSeen(this)) {
            (new Handler(Looper.getMainLooper())).postDelayed(this::toggleTooltip, 800);
        }

        backgroundView.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN && popupWindow.isShowing()) {
                toggleTooltip();
            }
            return false;
        });

        deleteFurnitureIV.setOnClickListener(v -> deleteCurrentModel());
        clearIV.setOnClickListener(v -> clearAllModels());
        closeScreenIV.setOnClickListener(v -> finish());
        helpIV.setOnClickListener(v -> toggleTooltip());
        addFurnitureIV.setOnClickListener(v -> addFurniture());
        screenshotIV.setOnClickListener(v -> attemptTakingScreenshot());
    }

    @Override
    protected void onResume() {
        super.onResume();
        isInResumeStage = true;

        try {
            arFragment.getArSceneView().resume();
        } catch (CameraNotAvailableException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        isInResumeStage = false;
        arFragment.getArSceneView().pause();
    }


    private void addFurniture() {
        if (errorOccurred) {
            MyToast.INSTANCE.makeText(FurnitureDropActivity.this, R.string.msg_furniture_drop_app_error);
        } else if (!hasFinishedLoading) {
            MyToast.INSTANCE.makeText(FurnitureDropActivity.this, R.string.please_wait);
        } else {
            toggleFurnitureDropDialog();
        }
    }

    @TargetApi(Build.VERSION_CODES.N)
    private void loadARModels() {
        furnitureSetRenderables[0] = Uri.parse(FURNITURE_SET_1);
        furnitureSetRenderables[1] = Uri.parse(FURNITURE_SET_2);
        furnitureSetRenderables[2] = Uri.parse(FURNITURE_SET_3);
        furnitureSetRenderables[3] = Uri.parse(FURNITURE_SET_4);
        furnitureSetRenderables[4] = Uri.parse(FURNITURE_SET_5);
        furnitureSetRenderables[5] = Uri.parse(FURNITURE_SET_6);

        CompletableFuture<ViewRenderable> deleteNodeStage =
                ViewRenderable.builder().setView(this, R.layout.layout_pointer).build();

        CompletableFuture.allOf(
                deleteNodeStage)
                .handle((notUsed, throwable) ->
                        handleCompletableFuture(throwable, deleteNodeStage));
    }

    private Object handleCompletableFuture(Throwable throwable, CompletableFuture<ViewRenderable> deleteNodeStage) {
        // When you build a Renderable, Sceneform loads its resources in the background while
        // returning a CompletableFuture. Call handle(), thenAccept(), or check isDone()
        // before calling get().
        if (throwable != null) {
            Log.d("", "AR::Unable to load renderable");
            MyToast.INSTANCE.makeText(this, R.string.msg_something_went_wrong);
            return null;
        }

        try {
            deleteRenderable = deleteNodeStage.get();

            //Everything finished loading successfully.
            hasFinishedLoading = true;

        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
            MyToast.INSTANCE.makeText(this, R.string.msg_something_went_wrong);
        }
        return null;
    }

    @Override
    public void onFurnitureSelected(int position) {
        showModel(position, false);
    }

    @Override
    public void onFurnitureSetSelected(int position) {
        showModel(position, true);
    }

    private void onArSceneViewUpdate(ArSceneView arSceneView, FrameTime frameTime) {
        arFragment.onUpdate(frameTime);
        Frame frame = arSceneView.getArFrame();

        if (frame == null) {
            return;
        }

        if (frame.getCamera().getTrackingState() != TrackingState.TRACKING) {
            return;
        }

        for (Plane plane : frame.getUpdatedTrackables(Plane.class)) {
            if (plane.getTrackingState() == TrackingState.TRACKING) {
                addFurnitureIV.setVisibility(View.VISIBLE);
                screenshotIV.setVisibility(View.VISIBLE);
                clearIV.setVisibility(View.VISIBLE);

                hideShowDelete();
                handleLookAtCamera();
                break;
            }
        }
    }

    private void handleLookAtCamera() {
        for (TransformableNode furnitureNode : nodes) {
            if (furnitureNode.getChildren().size() > 0) {
                Node pointerNode = furnitureNode.getChildren().get(0);

                if (furnitureNode.getScene() == null) {
                    return;
                }
                Vector3 cameraPosition = furnitureNode.getScene().getCamera().getWorldPosition();
                Vector3 cardPosition = pointerNode.getWorldPosition();
                Vector3 direction = Vector3.subtract(cameraPosition, cardPosition);
                Quaternion lookRotation = Quaternion.lookRotation(direction, Vector3.up());
                pointerNode.setWorldRotation(lookRotation);
            }
        }
    }

    private void handleOnTouch(HitTestResult hitTestResult, MotionEvent motionEvent) {
        // First call ArFragment's listener to handle TransformableNodes.
        arFragment.onPeekTouch(hitTestResult, motionEvent);

        // Check for touching a Sceneform node
        if (hitTestResult.getNode() != null) {
            return;
        }
        // Otherwise call gesture detector.
        trackableGestureDetector.onTouchEvent(motionEvent);
    }

    void toggleFurnitureDropDialog() {
        if (furnitureDropDialog == null || !furnitureDropDialog.isShowing()) {
            furnitureDropDialog = FurnitureDropDialog.newInstance(this, this);
            furnitureDropDialog.show();
        } else {
            hideFurnitureDropDialog();
        }
    }


    private void hideFurnitureDropDialog() {
        if (null != furnitureDropDialog) {
            furnitureDropDialog.dismiss();
        }
        furnitureDropDialog = null;
    }

    private void showModel(int position, boolean isFurnitureSet) {
        if (!hasFinishedLoading) {
            return;
        }

        List<HitResult> hitResultList = arFragment.getArSceneView().getArFrame().hitTest(getScreenCenter().x, getScreenCenter().y);

        for (HitResult hitResult : hitResultList) {
            if (hitResult.getTrackable() instanceof Plane) {
                Plane plane = (Plane) hitResult.getTrackable();

                if (plane.getType() == Type.HORIZONTAL_UPWARD_FACING) {
                    placeModel(hitResult, position, isFurnitureSet);
                    break;
                }
            }
        }
    }

    private void deleteCurrentModel() {
        if (currentNode == null)
            return;
        nodes.remove(currentNode);
        currentNode.setParent(null);
        currentNode = null;
    }

    private void clearAllModels() {
        for (Node node : nodes) {
            node.setParent(null);
        }
        nodes.clear();
    }

    private void hideShowDelete() {
        if (nodes.size() == 0) {
            clearIV.setVisibility(View.GONE);
            deleteFurnitureIV.setVisibility(View.GONE);
            return;
        } else {
            clearIV.setVisibility(View.VISIBLE);
        }

        if (currentNode == null) {
            deleteFurnitureIV.setVisibility(View.GONE);
        } else {
            deleteFurnitureIV.setVisibility(View.VISIBLE);
        }
    }


    private android.graphics.Point getScreenCenter() {
        View vw = findViewById(android.R.id.content);
        return new android.graphics.Point(vw.getWidth() / 2, vw.getHeight() / 2);
    }

    private void placeModel(HitResult hitResult, int position, boolean isFurnitureSet) {
        hideFurnitureDropDialog();

        // Create the Anchor.
        Anchor anchor = hitResult.createAnchor();
        placeObject(arFragment, anchor, furnitureSetRenderables[position]);
    }


    private void placeObject(ArFragment fragment, Anchor anchor, Uri model) {
        showProgressDialog(this);

        CompletableFuture<Void> renderableFuture =
                ModelRenderable.builder()
                        .setSource(fragment.getContext(), model)
                        .build()
                        .thenAccept(renderable -> {
                            addNodeToScene(fragment, anchor, renderable);
                        })
                        .exceptionally((throwable -> {
                            AlertDialog.Builder builder = new AlertDialog.Builder(this);
                            builder.setMessage(throwable.getMessage())
                                    .setTitle("Codelab error!");
                            AlertDialog dialog = builder.create();
                            dialog.show();
                            return null;
                        }));
    }

    private void addNodeToScene(ArFragment fragment, Anchor anchor, Renderable renderable) {

        if (currentNode != null) {
            currentNode.setParent(null);
            currentNode = null;
        }

        AnchorNode anchorNode = new AnchorNode(anchor);
        anchorNode.setParent(arFragment.getArSceneView().getScene());

        TransformableNode furnitureNode = new TransformableNode(arFragment.getTransformationSystem());
        furnitureNode.setParent(anchorNode);
        furnitureNode.setRenderable(renderable);
        furnitureNode.setLocalRotation(Quaternion.axisAngle(new Vector3(0, 1f, 0), 180));
        furnitureNode.getScaleController().setEnabled(false);
        furnitureNode.select();

        Node deleteNode = new Node();
        deleteNode.setParent(furnitureNode);
        deleteNode.setName(POINTER_NODE);
        deleteNode.setRenderable(deleteRenderable);
        deleteNode.setWorldScale(new Vector3(0.6f, 0.6f, 0.6f));
        deleteNode.setLocalPosition(new Vector3(0.0f, furnitureNode.getLocalScale().y - 0.2f, 0));
        deleteNode.setEnabled(false);

        furnitureNode.setOnTapListener(new Node.OnTapListener() {
            @Override
            public void onTap(HitTestResult hitTestResult, MotionEvent motionEvent) {
                for (TransformableNode node : nodes) {
                    List<Node> childNodes = node.getChildren();
                    if (childNodes.size() > 0) {
                        Node childNode = childNodes.get(0);
                        if (childNode != deleteNode) {
                            childNode.setEnabled(false);
                        }
                    }
                }
                deleteNode.setEnabled(!deleteNode.isEnabled());
                furnitureNode.select();

                if (deleteNode.isEnabled()) {
                    currentNode = furnitureNode;
                } else {
                    currentNode = null;
                }
            }
        });

        dismissProgressDialog();

        nodes.add(furnitureNode);
    }


    private void toggleTooltip() {
        if (!isInResumeStage) {
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


    private void attemptTakingScreenshot() {
        List<String> permissionEntityList = new ArrayList<>();
        permissionEntityList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (checkAndRequestPermissions(RC_SCREENSHOT_PERMISSIONS, permissionEntityList)) {
            permissionRequested = false;
            takeScreenshot();
        } else {
            permissionRequested = true;
        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NotNull List<String> grantedPermissionList) {
        super.onPermissionsGranted(requestCode, grantedPermissionList);
        if (requestCode == RC_SCREENSHOT_PERMISSIONS && permissionRequested) {
            takeScreenshot();
        }
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NotNull List<String> grantedPermissionsList, @NotNull List<String> deniedPermissionsList) {
        if (!deniedPermissionsList.isEmpty()) {
            MyToast.INSTANCE.makeText(this, R.string.msg_furniture_app_screenshot_permission_rejected);
        }
    }

    private void takeScreenshot() {
        ArSceneView arSceneView = arFragment.getArSceneView();
        final Bitmap bitmap = Bitmap.createBitmap(arSceneView.getWidth(), arSceneView.getHeight(), Bitmap.Config.ARGB_8888);

        showProgressDialog(this);

        final HandlerThread handlerThread = new HandlerThread("PixelCopier");
        handlerThread.start();

        PixelCopy.request(arSceneView, bitmap, (copyResult) -> {
                    if (copyResult == PixelCopy.SUCCESS) {
                        saveBitmap(bitmap);
                    } else {
                        dismissProgressDialog();
                        MyToast.INSTANCE.makeText(this, R.string.msg_something_went_wrong);
                    }

                    handlerThread.quitSafely();
                },
                new Handler(handlerThread.getLooper()));
    }

    private void saveBitmap(Bitmap bitmap) {
        String fileName = System.currentTimeMillis() + ".jpg";

        //Saving screenshot
        String uri = ImageFileUtil.INSTANCE.savePublicImage(this, bitmap, fileName);

        runOnUiThread(() -> {
            dismissProgressDialog();

            if (!TextUtils.isEmpty(uri)) {
                MyToast.INSTANCE.makeText(FurnitureDropActivity.this, R.string.msg_ar_furniture_screenshot_success);
                //MediaScannerConnection.scanFile(this, new String[]{uri}, new String[]{"image/jpg"}, null);
            } else {
                MyToast.INSTANCE.makeText(FurnitureDropActivity.this, R.string.msg_something_went_wrong);
            }
        });
    }

    private void showProgressDialog(Context context) {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }

        ProgressBar progressBar = new ProgressBar(context);
        Drawable drawable = progressBar.getIndeterminateDrawable();

        if (drawable != null) {
            drawable.setColorFilter(Color.BLACK, PorterDuff.Mode.MULTIPLY);
        }

        progressDialog = new Dialog(context);
        progressDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        progressDialog.setContentView(progressBar);

        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }

    private void dismissProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    @Override
    protected void onAppInForeground() {
    }

    @Override
    protected void onAppInBackground() {
    }
}
