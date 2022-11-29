package com.bhi.commonlib.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0019\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u0000H&\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/bhi/commonlib/util/ResponseListener;", "T", "", "onFailure", "", "error", "", "onSuccess", "data", "(Ljava/lang/Object;)V", "commonlib_stage"})
public abstract interface ResponseListener<T extends java.lang.Object> {
    
    public abstract void onSuccess(@org.jetbrains.annotations.Nullable()
    T data);
    
    public abstract void onFailure(@org.jetbrains.annotations.NotNull()
    java.lang.Throwable error);
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 3)
    public final class DefaultImpls {
    }
}