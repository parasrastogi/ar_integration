package com.bhi.commonlib.util.permission

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast
import androidx.core.content.ContextCompat

object PermissionHelper {
    fun hasPermission(context: Context, permissions: List<String>): Boolean {
        if (Build.VERSION.SDK_INT >= 23) {
            for (permission in permissions) {
                if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false
                }
            }
            return true
        } else {
            return true
        }
    }

    fun canRequestForBackgroundLocationPermission(): Boolean {
        return Build.VERSION.SDK_INT > 28
    }

    fun hasPermission(context: Context, vararg permissions: String): Boolean {
        if (Build.VERSION.SDK_INT >= 23) {
            for (permission in permissions) {
                if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false
                }
            }
            return true
        } else {
            return true
        }
    }
}