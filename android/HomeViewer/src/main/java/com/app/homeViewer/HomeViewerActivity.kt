package com.app.homeViewer

import android.Manifest
import android.annotation.TargetApi
import android.app.AlertDialog
import android.graphics.Color
import android.graphics.PorterDuff
import android.media.MediaScannerConnection
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.util.DisplayMetrics
import android.view.View
import com.app.homeViewer.util.HomeViewerFileUtil
import com.app.homeViewer.util.SceneFormUtil
import com.bhi.commonlib.util.BaseActivity
import com.bhi.commonlib.util.MyToast
import com.bhi.commonlib.util.permission.PermissionHelper
import com.google.ar.core.Anchor
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.FrameTime
import com.google.ar.sceneform.Node
import com.google.ar.sceneform.Scene
import com.google.ar.sceneform.math.Vector3
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.ux.TransformableNode
import kotlinx.android.synthetic.main.home_viewer_activity.*
import java.io.File
import java.util.*
import kotlin.properties.Delegates

@TargetApi(Build.VERSION_CODES.N)
class HomeViewerActivity : BaseActivity() {

    companion object {
        const val KEY_BDX_PLAN_ID = "bdx_plan_id"
        const val IS_SHOWING_ON_LOT = "is_showing_on_lot"
        const val KEY_TINT_COLOR = "tint_color"

        private const val COMPRESSED_FILE_EXTENSION = ".zip"

        private const val RC_HOME_VIEWER_PERMISSIONS = 101
        private const val RC_SCREENSHOT_PERMISSIONS = 102
        private val REQUIRED_PERMISSIONS = listOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    }

    private var bdxPlanId by Delegates.notNull<Int>()
    private var permissionRequested = false
    private var isShowingOnLot = false
    private var progressTint = Color.BLACK
    private lateinit var homeViewerArFragment: HorizontalPlaneArFragment
    private var structureRenderable: ModelRenderable? = null
    private var roofRenderable: ModelRenderable? = null
    private var selectedModelAnchorNode: AnchorNode? = null
    private var roofNode: Node? = null

    //This directory holds current model's unzipped file.
    private lateinit var currentModelDirectory: File

    //This is the zip file of current model which gets downloaded in current model's directory.
    private lateinit var homeViewerZipFile: File
    private var isModelAdded = false
    private var isRoofAdded = false

    override fun onAppInForeground() {
    }

    override fun onAppInBackground() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_viewer_activity)

        //getting extras
        bdxPlanId = intent.extras!!.getInt(KEY_BDX_PLAN_ID)
        isShowingOnLot = intent.extras!!.getBoolean(IS_SHOWING_ON_LOT, false)
        progressTint = intent.extras!!.getInt(KEY_TINT_COLOR, Color.BLACK)

        homeViewerArFragment =
            supportFragmentManager.findFragmentById(R.id.ar_fragment_home_on_lot) as HorizontalPlaneArFragment
        homeViewerArFragment.arSceneView.planeRenderer.isVisible = false
        homeViewerArFragment.arSceneView.scene.addOnUpdateListener(OnFrameUpdateListener())
        homeViewerArFragment.transformationSystem.selectionVisualizer = BlankSelectionVisualizer()

        //Initializing directories and file
        initDirectoryAndFiles()

        imv_delete_model.visibility = if (HomeViewerFileUtil.isRenderableFilesExist(currentModelDirectory)) View.VISIBLE else View.GONE

        //Note: If Camera permission is granted then only we're moving forward. If not granted,
        //the camera permission would have been requested by this time by scene form's ArFragment class.
        //In this case, we'll check for further permission in onRequestPermissionsResult() method.
        if (PermissionHelper.hasPermission(this, Manifest.permission.CAMERA)) {
            loadRenderableFiles()
        }

        imv_close_screen.setOnClickListener(this)
        imv_delete_model.setOnClickListener(this)
        tbtn_toggle_roof.setOnClickListener(this)
        imv_toggle_model.setOnClickListener(this)
        imv_screenshot.setOnClickListener(this)
    }

    private fun initDirectoryAndFiles() {
        val prefix = if (isShowingOnLot) "HomeOnLot" else "HomePreview"
        //This directory will keep 3D model folder of every plan.
        val allModelsDirectory = File(filesDir, "$prefix/Models")
        if (!allModelsDirectory.exists()) {
            allModelsDirectory.mkdirs()
        }

        currentModelDirectory = File(allModelsDirectory, bdxPlanId.toString())
        if (!currentModelDirectory.exists()) {
            currentModelDirectory.mkdirs()
        }

        homeViewerZipFile = File(currentModelDirectory, "$bdxPlanId$COMPRESSED_FILE_EXTENSION")
    }

    private inner class OnFrameUpdateListener : Scene.OnUpdateListener {

        override fun onUpdate(frameTime: FrameTime?) {
            if (HomeViewerFileUtil.isRenderableFilesExist(currentModelDirectory) && !isModelAdded) {
                if (isPlaneDetected()) {
                    setMessage(getString(R.string.msg_place_model))
                    txv_place_home_indicator.visibility = View.VISIBLE
                    imv_toggle_model.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN)
                } else {
                    setMessage(getString(R.string.msg_detect_surface))
                    txv_place_home_indicator.visibility = View.GONE
                    imv_toggle_model.setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN)
                }
            }
        }
    }

    override fun onPermissionsGranted(requestCode: Int, grantedPermissionList: List<String>) {
        super.onPermissionsGranted(requestCode, grantedPermissionList)
        if (RC_HOME_VIEWER_PERMISSIONS == requestCode) {
            loadRenderableFiles()
        } else if (RC_SCREENSHOT_PERMISSIONS == requestCode) {
            attemptTakingScreenshot()
        }
    }

    override fun onPermissionsDenied(
        requestCode: Int,
        grantedPermissionsList: List<String>,
        deniedPermissionsList: List<String>
    ) {
        super.onPermissionsDenied(requestCode, grantedPermissionsList, deniedPermissionsList)
        MyToast.makeText(this, R.string.msg_home_on_lot_permission_rejection)
        finish()
    }

    private fun loadRenderableFiles() {
        if (checkAndRequestPermissions(RC_HOME_VIEWER_PERMISSIONS, REQUIRED_PERMISSIONS)) {
            if (HomeViewerFileUtil.isRenderableFilesExist(currentModelDirectory)) {
                //At first, loading roof model then we'll load structure model.
                loadRoofRenderable()
                loadStructureRenderable()
            } else {
                MyToast.makeText(this, R.string.msg_no_model_home_exists)
                finish()
            }
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.imv_close_screen -> {
                finish()
            }

            R.id.tbtn_toggle_roof ->
                toggleRoof()

            R.id.imv_delete_model ->
                showDeleteModelConfirmation()

            R.id.imv_toggle_model ->
                toggleModel()

            R.id.imv_screenshot ->
                attemptTakingScreenshot()

            else -> {
                super.onClick(v)
            }
        }
    }

    private fun loadRoofRenderable() {
        val roofUri = Uri.fromFile(HomeViewerFileUtil.getRoofRenderableFile(currentModelDirectory))

        ModelRenderable.Builder()
                .setSource(this, roofUri)
                .build()
                .thenAccept { renderable ->
                    roofRenderable = renderable
                    roofRenderable?.isShadowReceiver = false
                    roofRenderable?.isShadowCaster = false

                    //After loading roof, now, loading structure renderable.
                    loadStructureRenderable()
                }
                .exceptionally {
                    roofRenderable = null
                    structureRenderable = null

                    MyToast.makeText(this, R.string.msg_something_went_wrong)
                    return@exceptionally null
                }
    }

    private fun loadStructureRenderable() {
        val structureUri = Uri.fromFile(HomeViewerFileUtil.getStructureRenderableFile(currentModelDirectory))

        ModelRenderable.Builder()
                .setSource(this, structureUri)
                .build()
                .thenAccept { renderable ->
                    structureRenderable = renderable
                    structureRenderable?.isShadowReceiver = false
                    structureRenderable?.isShadowCaster = false

                    imv_toggle_model.visibility = View.VISIBLE
                    setMessage(getString(R.string.msg_detect_surface))
                }
                .exceptionally {
                    roofRenderable = null
                    structureRenderable = null

                    MyToast.makeText(this, R.string.msg_something_went_wrong)
                    return@exceptionally null
                }
    }

    private fun toggleModel() {
        if (isModelAdded) {
            removeModel()
        } else {
            addModelInScene()
        }
    }

    private fun addModelInScene() {
        if (!HomeViewerFileUtil.isRenderableFilesExist(currentModelDirectory)) {
            MyToast.makeText(this, getString(R.string.msg_home_not_available))
            return
        }

        //Return, if no plan is detected.
        val anchor = getAnchor()

        if (anchor == null) {
            MyToast.makeText(this, R.string.msg_no_surface_is_detected)
            return
        }

        val anchorNode = AnchorNode(anchor)

        anchorNode.setParent(homeViewerArFragment.arSceneView.scene)
        selectedModelAnchorNode = anchorNode

        //Combining roof and structure nodes in it a same node.
        TransformableNode(homeViewerArFragment.transformationSystem).apply {
            if (isShowingOnLot) {

                //TODO: In v1.9.0 we've to enable scaleController.isEnabled to "true" to change the scaling of model.
                //TODO: Showing model in front of Camera is left.

                rotationController.isEnabled = false
                translationController.isEnabled = false
            } else {
                scaleController.isEnabled = true
                rotationController.isEnabled = true
                translationController.isEnabled = true

                scaleController.minScale = 0.03f
                scaleController.maxScale = 0.15f
                worldScale = Vector3(0.05f, 0.05f, 0.05f)
            }

            setParent(anchorNode)

            roofNode = Node()
            roofNode!!.renderable = roofRenderable
            roofNode!!.setParent(this)

            val structureNode = Node()
            structureNode.renderable = structureRenderable
            structureNode.setParent(this)


        }

        isModelAdded = true
        isRoofAdded = true

        setMessage(getString(if (isShowingOnLot) R.string.msg_move_into_home else R.string.msg_rotate_scale_and_move_model))
        txv_place_home_indicator.visibility = View.GONE

        if (!isShowingOnLot) {
            tbtn_toggle_roof.visibility = View.VISIBLE
        }

        imv_screenshot.visibility = View.VISIBLE
        imv_toggle_model.setImageResource(R.drawable.ic_clear)
        tbtn_toggle_roof.isChecked = true
    }

    private fun isPlaneDetected(): Boolean {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val x = displayMetrics.widthPixels / 2f
        val y = displayMetrics.heightPixels / 2f

        return SceneFormUtil.isPlaneDetected(homeViewerArFragment.arSceneView?.arFrame, x, y)
    }

    /**
     * Provides anchor from center of screen, if possible.
     */
    private fun getAnchor(): Anchor? {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val x = displayMetrics.widthPixels / 2f
        val y = displayMetrics.heightPixels / 2f

        val hitResult = SceneFormUtil.getHitResult(homeViewerArFragment.arSceneView?.arFrame, x, y)
        val hitPose = hitResult?.hitPose
                ?: return null
        return homeViewerArFragment.arSceneView.session?.createAnchor(hitPose)
    }


    private fun toggleRoof() {
        val parentNode = selectedModelAnchorNode?.children?.firstOrNull()
        if (isRoofAdded) {
            isRoofAdded = false
            parentNode?.removeChild(roofNode)
            roofNode?.setParent(null)
            tbtn_toggle_roof.isChecked = false
        } else {
            isRoofAdded = true
            roofNode = Node()
            roofNode!!.renderable = roofRenderable
            roofNode!!.setParent(parentNode)
            tbtn_toggle_roof.isChecked = true
        }
    }

    private fun removeModel() {
        isModelAdded = false

        selectedModelAnchorNode?.anchor?.detach()
        selectedModelAnchorNode?.setParent(null)
        selectedModelAnchorNode = null
        roofNode = null

        tbtn_toggle_roof.visibility = View.GONE
        imv_toggle_model.setImageResource(R.drawable.ic_add_model)
        imv_screenshot.visibility = View.GONE
    }


    private fun showDeleteModelConfirmation() {
        AlertDialog.Builder(this)
                .setMessage(R.string.msg_delete_model)
                .setPositiveButton(R.string.yes) { _, _ ->
                    deleteModelFromDisk()
                }
                .setNegativeButton(R.string.no, null)
                .show()
    }

    private fun deleteModelFromDisk() {
        //Deleting all files and folders related to current plan
        currentModelDirectory.deleteRecursively()

        removeModel()

        MyToast.makeText(this, R.string.msg_model_delete_success)
        imv_delete_model.visibility = View.GONE
        imv_toggle_model.visibility = View.GONE
        finish()
    }

    private fun attemptTakingScreenshot() {
        val permissionEntityList = ArrayList<String>()
        permissionEntityList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)

        if (checkAndRequestPermissions(RC_SCREENSHOT_PERMISSIONS, permissionEntityList)) {
            permissionRequested = false
            takeScreenshot()
        } else {
            permissionRequested = true
        }
    }


    private fun takeScreenshot() {
        val fileName = System.currentTimeMillis().toString() + ".jpg"

        fl_progress.visibility = View.VISIBLE

        ScreenshotHelper.saveScreenshot(homeViewerArFragment.arSceneView, fileName,
                { file -> onScreenshotSuccess(file) },
                { onScreenshotError() })
    }

    private fun onScreenshotSuccess(imageFile: String) {
        fl_progress.visibility = View.GONE
        MyToast.makeText(this@HomeViewerActivity, R.string.msg_screenshot_save_success)

        MediaScannerConnection.scanFile(this@HomeViewerActivity, arrayOf(imageFile), arrayOf("image/jpg"), null)
    }

    private fun onScreenshotError() {
        fl_progress.visibility = View.GONE
        MyToast.makeText(this, R.string.msg_something_went_wrong)
    }


    private fun setMessage(message: String?) {
        if (TextUtils.isEmpty(message)) {
            txv_message.visibility = View.GONE
        } else {
            txv_message.visibility = View.VISIBLE
            txv_message.text = message
        }
    }

}