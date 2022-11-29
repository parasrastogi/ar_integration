package com.bhi.commonlib.app

import android.app.Activity
import com.bhi.commonlib.util.ActivityUtils

/**
 * This class handles app state handling when it gets started after being killed by android system due to several reasons like:
 * lack of memory, configuration change etc.
 */
object ProcessUtil {

    /**
     * Must initialize this with the main application id.
     */
    lateinit var mainApplicationId: String

    /**
     * ProcessUtil#isAppStartManageInProgress() is a custom logic just to detect whether the app has been created normally or re-created after
     * process being killed by android system.
     */
    var isAppProcessNormallyCreated = false
    private var isNormalAppStartInProgress = false

    fun restartAppNormally(activity: Activity) {
        if (isNormalAppStartInProgress) {
            return
        }

        isNormalAppStartInProgress = true

        activity.packageManager.getLaunchIntentForPackage(mainApplicationId)?.apply {
            ActivityUtils.clearBackStackActivities(activity, this)
            activity.finish()
        }
    }

    fun onProcessNormallyCreated() {
        isAppProcessNormallyCreated = true
        isNormalAppStartInProgress = false
    }

}