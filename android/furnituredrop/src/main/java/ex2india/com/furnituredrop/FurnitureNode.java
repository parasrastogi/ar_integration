package ex2india.com.furnituredrop;

import android.content.Context;
import android.view.MotionEvent;

import com.google.ar.sceneform.FrameTime;
import com.google.ar.sceneform.HitTestResult;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.math.Quaternion;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.TransformableNode;
import com.google.ar.sceneform.ux.TransformationSystem;

import ex2india.com.furnituredrop.dropdialog.OnNodeTapListener;

public class FurnitureNode extends TransformableNode implements Node.OnTapListener{

    private Node deleteNode;
    private ViewRenderable deleteViewRenderable;
    private final Context context;
    private static final float INFO_CARD_Y_POS_COEFF = 0.05f;
    private OnNodeTapListener nodeTapListener;

    public FurnitureNode(TransformationSystem transformationSystem, Context context, ViewRenderable deleteViewRenderable, OnNodeTapListener nodeTapListener) {
        super(transformationSystem);
        this.context = context;
        this.deleteViewRenderable = deleteViewRenderable;
        this.nodeTapListener = nodeTapListener;
//        getRotationController().setEnabled(true);
//        getTranslationController().setEnabled(true);
//
//        transformationSystem.getSelectedNode().getRotationController().setEnabled(true);
//        transformationSystem.getSelectedNode().getTranslationController().setEnabled(true);

    }

    @Override
    @SuppressWarnings({"AndroidApiChecker", "FutureReturnValueIgnored"})
    public void onActivate() {

        if (getScene() == null) {
            throw new IllegalStateException("Scene is null!");
        }

        if (deleteNode == null) {
            deleteNode = new Node();
            deleteNode.setParent(this);
            deleteNode.setEnabled(false);
            deleteNode.setLocalPosition(new Vector3(0.0f, this.getLocalScale().y + INFO_CARD_Y_POS_COEFF, 0.0f));
            deleteNode.setRenderable(deleteViewRenderable);
        }

    }

    @Override
    public void onTap(HitTestResult hitTestResult, MotionEvent motionEvent) {
        if (deleteNode == null) {
            return;
        }
        this.select();
        deleteNode.setEnabled(!deleteNode.isEnabled());
        nodeTapListener.onDeleteTap(this, deleteNode.isEnabled());
    }

    @Override
    public void onUpdate(FrameTime frameTime) {
        if (deleteNode == null) {
            return;
        }

        // Typically, getScene() will never return null because onUpdate() is only called when the node
        // is in the scene.
        // However, if onUpdate is called explicitly or if the node is removed from the scene on a
        // different thread during onUpdate, then getScene may be null.
        if (getScene() == null) {
            return;
        }
        Vector3 cameraPosition = getScene().getCamera().getWorldPosition();
        Vector3 cardPosition = deleteNode.getWorldPosition();
        Vector3 direction = Vector3.subtract(cameraPosition, cardPosition);
        Quaternion lookRotation = Quaternion.lookRotation(direction, Vector3.up());
        deleteNode.setWorldRotation(lookRotation);
    }

}
