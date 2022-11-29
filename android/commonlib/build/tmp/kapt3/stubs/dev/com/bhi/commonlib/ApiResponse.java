package com.bhi.commonlib;

import java.lang.System;

/**
 * Common API response model which is used most of the time.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"Lcom/bhi/commonlib/ApiResponse;", "T", "Lcom/bhi/commonlib/BaseResponse;", "()V", "result", "getResult", "()Ljava/lang/Object;", "setResult", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "commonlib_dev"})
public class ApiResponse<T extends java.lang.Object> extends com.bhi.commonlib.BaseResponse {
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "Model")
    private T result;
    
    public ApiResponse() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final T getResult() {
        return null;
    }
    
    public final void setResult(@org.jetbrains.annotations.Nullable()
    T p0) {
    }
}