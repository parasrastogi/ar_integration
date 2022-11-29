package com.bhi.commonlib.util

interface ResponseListener<T> {
    fun onSuccess(data: T? = null)
    fun onFailure(error: Throwable)
}