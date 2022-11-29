package com.bhi.commonlib

interface ApiSuccessListener<T> {
    fun onSuccess(data: T)
}