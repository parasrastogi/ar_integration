package com.app.homeViewer.util.zip

import com.android.volley.AuthFailureError
import com.android.volley.NetworkResponse
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.HttpHeaderParser

class InputStreamVolleyRequest(method: Int, mUrl: String, private val mListener: Response.Listener<ByteArray>, errorListener: Response.ErrorListener,
                               var mParams: MutableMap<String, String> = mutableMapOf()) : Request<ByteArray>(method, mUrl, errorListener) {

    //create a static map for directly accessing headers
    var responseHeaders: Map<String, String>? = null

    init {
        // this request would never use cache.
        setShouldCache(false)
    }

    @Throws(AuthFailureError::class)
    override fun getParams(): Map<String, String> {
        return mParams
    }

    override fun deliverResponse(response: ByteArray) {
        mListener.onResponse(response)
    }

    override fun parseNetworkResponse(response: NetworkResponse): Response<ByteArray> {
        responseHeaders = response.headers
        return Response.success(response.data, HttpHeaderParser.parseCacheHeaders(response))
    }


}
 