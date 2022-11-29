package com.app.homeViewer

import android.graphics.Bitmap
import android.os.Build
import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.view.PixelCopy
import androidx.annotation.RequiresApi
import com.bhi.commonlib.util.ImageFileUtil
import com.google.ar.sceneform.SceneView

object ScreenshotHelper {

    /**
     * As ArCore support isn't below android N. So, this method isn't going to be called below android-N
     * in any case.
     */
    @RequiresApi(Build.VERSION_CODES.N)
    fun saveScreenshot(arSceneView: SceneView, fileName: String,
                       onSuccess: (screenshotFile: String) -> Unit, onError: () -> Unit) {

        val backgroundThread = HandlerThread("PixelCopier")
        backgroundThread.start()

        val backgroundHandler = Handler(backgroundThread.looper)
        val responseHandler = Handler(Looper.getMainLooper())
        val screenshotBitmap = Bitmap.createBitmap(arSceneView.width, arSceneView.height, Bitmap.Config.ARGB_8888)

        PixelCopy.request(arSceneView, screenshotBitmap, { copyResult ->
            if (copyResult == PixelCopy.SUCCESS) {
                //Creating directory, if doesn't exist.

                //Saving screenshot
                val success = ImageFileUtil.savePublicImage(arSceneView.context, screenshotBitmap, fileName)

                responseHandler.post {
                    if (success != null) {
                        onSuccess(success)
                    } else {
                        onError()
                    }
                }
            } else {
                responseHandler.post {
                    onError()
                }
            }
            backgroundThread.quitSafely()
        }, backgroundHandler)
    }
}