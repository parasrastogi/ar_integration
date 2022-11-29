package com.bhi.commonlib.util

import android.text.TextUtils
import androidx.test.espresso.idling.net.UriIdlingResource

/**
 * An idling resource for API calls used in Espresso framework.
 */
class ApiIdlingResource(name: String = ApiIdlingResource::class.java.name, timeout: Long = 10L)
    : UriIdlingResource(name, timeout) {

    val uriList = mutableListOf<String>()

    override fun beginLoad(uri: String?) {
        super.beginLoad(uri)

        if (!TextUtils.isEmpty(uri)) {
            uriList.add(uri!!)
        }
    }

    override fun endLoad(uri: String?) {
        super.endLoad(uri)
        uriList.remove(uri)
    }

}