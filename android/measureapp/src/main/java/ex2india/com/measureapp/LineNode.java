package ex2india.com.measureapp;

import android.content.Context;
import android.os.Build;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.google.ar.sceneform.FrameTime;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.math.Quaternion;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.ViewRenderable;

/**
 * Holds line details which is drawn to measure length between two points using AR measurement tool.
 */
@RequiresApi(api = Build.VERSION_CODES.N)
public class LineNode extends Node {

    private Double length;
    private Node infoCard;
    private ViewRenderable textRenderable;
    private final Context context;
    private Vector3 worldPositionInfoCard;
    private boolean isPositionSet = false;

    public void setWorldPositionInfoCard(Vector3 worldPosition) {
        this.worldPositionInfoCard = worldPosition;
    }

    private String lengthStr;

    LineNode(Context context) {
        this.context = context;
    }

    public void setLengthStr(String lengthStr) {
        this.lengthStr = lengthStr;
    }



    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    @Override
    public void onActivate() {
        super.onActivate();

        if (getScene() == null) {
            throw new IllegalStateException("Scene is null!");
        }

        if (infoCard == null) {
            infoCard = new Node();
            infoCard.setParent(this);

            ViewRenderable.builder()
                    .setView(context, R.layout.size_view_renderable)
                    .build()
                    .thenAccept(
                            (renderable) -> {
                                textRenderable = renderable;
                                infoCard.setRenderable(textRenderable);
                            })
                    .exceptionally(
                            (throwable) -> {
                                throw new AssertionError("Could not load plane card view.", throwable);
                            });
        }
    }

    @Override
    public void onUpdate(FrameTime frameTime) {
        super.onUpdate(frameTime);

        if (infoCard == null) {
            return;
        }
        if (getScene() == null) {
            return;
        }
        Vector3 cameraPosition = getScene().getCamera().getWorldPosition();
        Vector3 cardPosition = infoCard.getWorldPosition();
        Vector3 direction = Vector3.subtract(cameraPosition, cardPosition);
        Quaternion lookRotation = Quaternion.lookRotation(direction, Vector3.up());
        infoCard.setWorldRotation(lookRotation);
        setInfoPosition();
        displayLength();
    }

    public void setInfoPosition(){
        if (!isPositionSet && worldPositionInfoCard != null) {
            infoCard.setWorldPosition(worldPositionInfoCard);
            isPositionSet = true;
        }
    }

    public void displayLength(){
        if (infoCard == null || textRenderable == null) {
            return;
        }

        TextView textView = (TextView) textRenderable.getView();
        textView.setText(lengthStr);
    }

}
