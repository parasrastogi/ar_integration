package com.app.homeViewer.util

import android.app.Activity
import android.app.ActivityManager
import android.content.Context.ACTIVITY_SERVICE
import android.os.Build
import android.util.Log
import com.google.ar.core.Frame
import com.google.ar.core.HitResult
import com.google.ar.core.Plane


object SceneFormUtil {

    fun isSceneFormSupported(activity: Activity): Boolean {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            Log.e("", "Sceneform requires Android N or later")
            return false
        }

        val openGlVersionString = (activity.getSystemService(ACTIVITY_SERVICE) as ActivityManager)
                .deviceConfigurationInfo
                .glEsVersion

        if (java.lang.Double.parseDouble(openGlVersionString) < 3.0) {
            Log.e("", "Sceneform requires OpenGL ES 3.0 later")
            return false
        }
        return true
    }


    fun isPlaneDetected(frame: Frame?, x: Float, y: Float): Boolean {
        return getHitResult(frame, x, y) != null
    }

    fun getHitResult(frame: Frame?, x: Float, y: Float): HitResult? {
        var hitResult: HitResult? = null
        val hitResultList = frame?.hitTest(x, y)

        if (null != hitResultList) {
            for (hit in hitResultList) {
                val trackable = hit.trackable

                if (trackable is Plane && (trackable).isPoseInPolygon(hit.hitPose)) {
                    hitResult = hit
                    break
                }
            }
        }

        return hitResult
    }

}