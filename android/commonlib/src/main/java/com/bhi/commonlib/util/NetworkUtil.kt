package com.bhi.commonlib.util

import android.app.Service
import android.content.Context
import android.net.ConnectivityManager

/**
 * @author Rahul Rastogi.
 *
 * Provides network connection status whether connected or not.
 */
object NetworkUtil {

    fun isConnected(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Service.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetworkInfo

        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }
}
