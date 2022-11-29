package com.bhi.commonlib

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * @author Rahul Rastogi
 *
 * A base class having some common response properties across all type of API calls.
 */
open class BaseResponse : Serializable {

    @SerializedName("Error")
    var error: Boolean = false

    @SerializedName("ErrorMessage")
    var errorMessage: String? = null

    @SerializedName("Code")
    var code: Int = 0
    override fun equals(other: Any?): Boolean {
        if (this===other) return true
        if (javaClass!=other?.javaClass) return false

        other as BaseResponse

        if (error!=other.error) return false
        if (errorMessage!=other.errorMessage) return false
        if (code!=other.code) return false

        return true
    }

    override fun hashCode(): Int {
        var result = error.hashCode()
        result = 31 * result + (errorMessage?.hashCode() ?: 0)
        result = 31 * result + code
        return result
    }

    override fun toString(): String {
        return "BaseResponse(error=$error, errorMessage=$errorMessage, code=$code)"
    }
}
