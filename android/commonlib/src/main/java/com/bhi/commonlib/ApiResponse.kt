package com.bhi.commonlib

import com.google.gson.annotations.SerializedName

/**
 * Common API response model which is used most of the time.
 */
open class ApiResponse<T> : BaseResponse() {

    @SerializedName("Model")
    var result: T? = null
}