package ex2india.com.measureapp;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.bhi.commonlib.SessionManager;
import com.bhi.commonlib.app.ProcessUtil;
import com.google.ar.core.Anchor;
import com.google.ar.core.Frame;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.core.TrackingState;
import com.google.ar.core.exceptions.CameraNotAvailableException;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.ArSceneView;
import com.google.ar.sceneform.FrameTime;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.Scene;
import com.google.ar.sceneform.math.Quaternion;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.Color;
import com.google.ar.sceneform.rendering.MaterialFactory;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ShapeFactory;
import com.google.ar.sceneform.ux.ArFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * This screen shows AR measurement tool screen which lets users to measure length of something in various units (meters/centimeters/inches)
 * with the help of augmented reality technology.
 */
@RequiresApi(api = Build.VERSION_CODES.N)
public class MeasureActivity extends AppCompatActivity implements View.OnClickListener,
        CompoundButton.OnCheckedChangeListener {

    private static final float INCH = 39.3701f;
    private static final String SPHERE_NODE = "sphere";
    private static final int MEASURE_UNITS_COUNT = 3;

    private ArFragment arFragment;
    private ImageView centerImageView;
    private ImageView measureIV;
    private ImageView undoIV;
    private ImageView clearIV;
    private TextView messageTV;
    private ToggleButton continueModeButton;
    private LinearLayout measureUnitsLL;
    private PopupWindow popupWindow;
    private ImageView helpIV;
    private TextView measureUnitTV;
    private final TextView[] measurementUnitsTVArray = new TextView[MEASURE_UNITS_COUNT];
    private CheckBox cbDontShowAgain;

    private ModelRenderable whiteSphereRenderable;
    private ModelRenderable lineRenderable;
    private MeasurementUnit selectedUnit = MeasurementUnit.Inch;
    private ArrayList<Node> sphereNodes;
    private ArrayList<LineNode> lineNodes;
    private ArrayList<Node> allNodes;
    private boolean isInResumeStage;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measure);
        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.ux_fragment);
        View backgroundView = findViewById(R.id.view_background);
        ImageView closeScreenIV = findViewById(R.id.iv_close_screen);
        centerImageView = findViewById(R.id.center_iv);
        measureIV = findViewById(R.id.iv_measure);
        undoIV = findViewById(R.id.iv_undo);
        clearIV = findViewById(R.id.iv_clear);
        messageTV = findViewById(R.id.tv_message);
        continueModeButton = findViewById(R.id.continue_mode_toggle);
        measureUnitsLL = findViewById(R.id.ll_measure_units);
        helpIV = findViewById(R.id.iv_help);
        measureUnitTV = findViewById(R.id.tv_measure_unit);
        measurementUnitsTVArray[0] = findViewById(R.id.tv_centimeter);
        measurementUnitsTVArray[1] = findViewById(R.id.tv_inch);
        measurementUnitsTVArray[2] = findViewById(R.id.tv_meter);

        sphereNodes = new ArrayList<>();
        allNodes = new ArrayList<>();
        lineNodes = new ArrayList<>();

        MaterialFactory.makeOpaqueWithColor(this, new Color(android.graphics.Color.GREEN))
                .thenAccept(material -> {
                    whiteSphereRenderable =
                            ShapeFactory.makeSphere(0.01f, new Vector3(0.0f, 0.0f, 0.0f), material);
                    whiteSphereRenderable.setShadowReceiver(false);
                    whiteSphereRenderable.setShadowCaster(false);
                });

        MaterialFactory.makeOpaqueWithColor(this, new Color(android.graphics.Color.GREEN))
                .thenAccept(material -> {
                    lineRenderable = ShapeFactory.makeCube(new Vector3(.1f, .1f, .1f),
                            Vector3.zero(), material);
                    lineRenderable.setShadowReceiver(false);
                    lineRenderable.setShadowCaster(false);
                });

        ArSceneView arSceneView = arFragment.getArSceneView();
        arSceneView.getScene().addOnUpdateListener(new OnMeasurementSceneUpdateListener(arSceneView));

        //Configuring Tooltip dialog (Popup Window)
        View popupWindowView = LayoutInflater.from(this).inflate(R.layout.layout_measure_app_popup_window, null);
        TextView gotItTV = popupWindowView.findViewById(R.id.tv_got_it);
        cbDontShowAgain = popupWindowView.findViewById(R.id.cb_dont_show_again);
        cbDontShowAgain.setChecked(SessionManager.INSTANCE.isARMeasureHelperTextSeen(this));

        gotItTV.setOnClickListener(v -> {
            SessionManager.INSTANCE.setARMeasureHelperTextSeen(this, cbDontShowAgain.isChecked());
            toggleTooltip();
        });

        popupWindow = new PopupWindow();
        popupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setContentView(popupWindowView);

        if (!SessionManager.INSTANCE.isARMeasureHelperTextSeen(this)) {
            (new Handler(Looper.getMainLooper())).postDelayed(this::toggleTooltip, 800);
        }

        backgroundView.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN && popupWindow.isShowing()) {
                popupWindow.dismiss();
            }
            return false;
        });

        measureUnitTV.setOnClickListener(this);
        closeScreenIV.setOnClickListener(this);
        helpIV.setOnClickListener(this);
        measureIV.setOnClickListener(this);
        undoIV.setOnClickListener(this);
        clearIV.setOnClickListener(this);
        continueModeButton.setOnCheckedChangeListener(this);
        measurementUnitsTVArray[0].setOnClickListener(this);
        measurementUnitsTVArray[1].setOnClickListener(this);
        measurementUnitsTVArray[2].setOnClickListener(this);

        arFragment.getArSceneView().getPlaneRenderer().setShadowReceiver(false);
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

        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_centimeter) {
            onMeasurementUnitChange(0);

        } else if (v.getId() == R.id.tv_inch) {
            onMeasurementUnitChange(1);

        } else if (v.getId() == R.id.tv_meter) {
            onMeasurementUnitChange(2);

        } else if (v.getId() == R.id.tv_measure_unit) {
            toggleMeasureUnitsSelectionView();
        } else if (v.getId() == R.id.iv_close_screen) {
            finish();
        } else if (v.getId() == R.id.iv_help) {
            toggleTooltip();
        } else if (v.getId() == R.id.iv_measure) {
            addNode();
        } else if (v.getId() == R.id.iv_undo) {
            removeLastNode();
        } else if (v.getId() == R.id.iv_clear) {
            removeAllNodes();
        }
    }


    private void toggleMeasureUnitsSelectionView() {
        if (measureUnitsLL.getVisibility() == View.GONE) {
            measureUnitTV.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_collapse_arrow, 0);
            measureUnitTV.setBackgroundResource(R.drawable.rounded_drop_down_top);
            measureUnitsLL.setVisibility(View.VISIBLE);
        } else {
            measureUnitTV.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_expand_arrow, 0);
            measureUnitTV.setBackgroundResource(R.drawable.rounded_drop_down);
            measureUnitsLL.setVisibility(View.GONE);
        }
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

    private void addNode() {
        List<HitResult> results = arFragment.getArSceneView().getArFrame().hitTest(getScreenCenter().x, getScreenCenter().y);

        for (HitResult hitResult : results) {
            if (hitResult.getTrackable() instanceof Plane) {
                Plane plane = (Plane) hitResult.getTrackable();

                if (plane.getType() == Plane.Type.HORIZONTAL_UPWARD_FACING
                        || plane.getType() == Plane.Type.VERTICAL) {
                    addSphere(hitResult);
                    break;
                }
            }
        }
    }

    private void removeLastNode() {
        if (allNodes.size() == 1) {
            Node node = allNodes.get(allNodes.size() - 1);
            allNodes.remove(node);
            sphereNodes.remove(node);
            node.setParent(null);
            return;
        }

        if (allNodes.size() > 0) {
            Node node = allNodes.get(allNodes.size() - 1);
            allNodes.remove(node);
            if (!SPHERE_NODE.equals(node.getName())) {
                lineNodes.remove(node);
                Node sphere = allNodes.get(allNodes.size() - 1);
                sphere.setParent(null);
                sphereNodes.remove(sphere);
                allNodes.remove(sphere);
            } else {
                sphereNodes.remove(node);
            }
            node.setParent(null);
        }

        if(!allNodes.isEmpty()) {
            Node node = allNodes.get(allNodes.size() - 1);
            if (SPHERE_NODE.equals(node.getName())) {
                sphereNodes.remove(node);
                allNodes.remove(node);
                node.setParent(null);
            }
        }

        showDistance();
    }


    private void removeAllNodes() {
        for (Node node : allNodes) {
            node.setParent(null);
        }

        allNodes.clear();
        sphereNodes.clear();
        lineNodes.clear();

        showDistance();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.getId() == R.id.continue_mode_toggle) {
            toggleContinueMode(isChecked);
        }
    }


    private void toggleContinueMode(boolean isChecked) {
        if (!isChecked) {
            if (sphereNodes.size() % 2 != 0) {
                Node sphere = sphereNodes.get(sphereNodes.size() - 1);
                sphere.setParent(null);
                sphereNodes.remove(sphere);
            }
        }
    }

    private void onMeasurementUnitChange(int unitIndex) {
        //hiding/showing measure unit selection view
        toggleMeasureUnitsSelectionView();

        for (int index = 0; index < MEASURE_UNITS_COUNT; index++) {
            if (index == unitIndex) {
                measurementUnitsTVArray[index].setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_green_tick, 0);
            } else {
                measurementUnitsTVArray[index].setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }

        switch (unitIndex) {
            case 0:
                selectedUnit = MeasurementUnit.Centimeter;
                measureUnitTV.setText(R.string.centimeters);
                break;
            case 1:
                selectedUnit = MeasurementUnit.Inch;
                measureUnitTV.setText(R.string.inches);
                break;
            case 2:
                selectedUnit = MeasurementUnit.Meter;
                measureUnitTV.setText(R.string.meters);
                break;
            default:
                break;
        }

        showDistance();
    }

    private android.graphics.Point getScreenCenter() {
        View vw = findViewById(android.R.id.content);
        return new android.graphics.Point(vw.getWidth() / 2, vw.getHeight() / 2);
    }

    private void addSphere(HitResult hitResult) {
        Anchor anchor = hitResult.createAnchor();
        AnchorNode anchorNode = new AnchorNode(anchor);
        anchorNode.setParent(arFragment.getArSceneView().getScene());

        Node sphereNode = new Node();
        sphereNode.setParent(anchorNode);
        sphereNode.setName(SPHERE_NODE);
        sphereNode.setRenderable(whiteSphereRenderable);

        sphereNodes.add(sphereNode);
        allNodes.add(sphereNode);

        if (sphereNodes.size() > 1) {
            if (!continueModeButton.isChecked()) {
                if (sphereNodes.size() % 2 != 0) {
                    return;
                }
            }

            Vector3 point1 = sphereNodes.get(sphereNodes.size() - 2).getWorldPosition();
            Vector3 point2 = sphereNodes.get(sphereNodes.size() - 1).getWorldPosition();
            lineBetweenPoints(point1, point2, anchorNode);
        }
    }


    private void lineBetweenPoints(Vector3 point1, Vector3 point2, AnchorNode anchorNode) {
        final Vector3 difference = Vector3.subtract(point1, point2);
        final Vector3 directionFromTopToBottom = difference.normalized();
        final Quaternion rotationFromAToB =
                Quaternion.lookRotation(directionFromTopToBottom, Vector3.up());

        LineNode lineNode = new LineNode(MeasureActivity.this);
        lineNode.setParent(anchorNode);

        Node childNode = new Node();
        childNode.setRenderable(lineRenderable);
        childNode.setParent(lineNode);

        childNode.setWorldScale(new Vector3(.1f, .1f, difference.length() * 10));
        childNode.setWorldPosition(Vector3.add(point1, point2).scaled(.5f));
        childNode.setWorldRotation(rotationFromAToB);

        lineNode.setLength((double) difference.length());
        lineNode.setWorldPositionInfoCard(new Vector3(Vector3.add(point1, point2).scaled(.5f).x,
                Vector3.add(point1, point2).scaled(.477f).y,
                Vector3.add(point1, point2).scaled(.5f).z));

        allNodes.add(lineNode);
        lineNodes.add(lineNode);
        showDistance();
    }

    private void updateClearAndUndoButtons() {
        if (allNodes.size() > 0) {
            if (sphereNodes.size() % 2 == 0) {
                measureIV.setImageResource(R.drawable.ic_start_measure);
            } else {
                measureIV.setImageResource(R.drawable.ic_stop_measure);
            }
            undoIV.setVisibility(View.VISIBLE);
            clearIV.setVisibility(View.VISIBLE);
        } else {
            measureIV.setImageResource(R.drawable.ic_start_measure);
            undoIV.setVisibility(View.INVISIBLE);
            clearIV.setVisibility(View.INVISIBLE);
        }
    }


    @SuppressLint("DefaultLocale")
    private void showDistance() {
        if (lineNodes.size() > 0) {
            String value = getFormattedLength(lineNodes.get(lineNodes.size() - 1).getLength());
            String lastMeasurement = String.format(getString(R.string.last_measurement_value), value);
            messageTV.setText(lastMeasurement);

            setDistanceOverLines();
        } else {
            messageTV.setText(getResources().getString(R.string.tap_on_info));
        }
    }

    private String getFormattedLength(Double length) {
        String lengthStr = "";

        switch (selectedUnit) {
            case Inch:
                float totalInches = (float) (length * INCH);
                final int totalInchesInAFoot = 12;

                if (totalInches > totalInchesInAFoot) {
                    int feet = (int) (totalInches / totalInchesInAFoot);
                    float inches = totalInches % totalInchesInAFoot;

                    lengthStr = String.format(getString(R.string.feet_and_inches_value), feet, inches);
                } else {
                    lengthStr = String.format(getString(R.string.inches_value), totalInches);
                }
                break;

            case Meter:
                lengthStr = String.format(getString(R.string.meters_value), length);
                break;

            case Centimeter:
                double totalCentimeters = (length * 100);
                lengthStr = String.format(getString(R.string.centimeters_value), totalCentimeters);
                break;
        }

        return lengthStr;
    }

    private void setDistanceOverLines() {
        for (LineNode node : lineNodes) {
            String lengthStr = getFormattedLength(node.getLength());
            node.setLengthStr(lengthStr);
        }
    }


    /**
     * Callback to listens to every change made on scene view
     */
    private class OnMeasurementSceneUpdateListener implements Scene.OnUpdateListener {

        private final ArSceneView arSceneView;

        private OnMeasurementSceneUpdateListener(ArSceneView arSceneView) {
            this.arSceneView = arSceneView;
        }

        @Override
        public void onUpdate(FrameTime frameTime) {
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
                    //continueModeButton.setVisibility(View.VISIBLE);
                    measureIV.setVisibility(View.VISIBLE);
                    centerImageView.setVisibility(View.VISIBLE);
                    messageTV.setVisibility(View.VISIBLE);
                    measureUnitTV.setVisibility(View.VISIBLE);
                    updateClearAndUndoButtons();
                } else {
                    measureIV.setVisibility(View.INVISIBLE);
                    undoIV.setVisibility(View.INVISIBLE);
                    clearIV.setVisibility(View.INVISIBLE);
                }
            }
        }
    }

}
