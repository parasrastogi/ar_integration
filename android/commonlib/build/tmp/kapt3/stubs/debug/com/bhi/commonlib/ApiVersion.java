package com.bhi.commonlib;

import java.lang.System;

/**
 * Holds all API version numbers used with web APIs.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/bhi/commonlib/ApiVersion;", "", "()V", "NO_VERSION", "", "getNO_VERSION", "()F", "V2", "commonlib_debug"})
public final class ApiVersion {
    @org.jetbrains.annotations.NotNull()
    public static final com.bhi.commonlib.ApiVersion INSTANCE = null;
    public static final float V2 = 2.0F;
    private static final float NO_VERSION = 0.0F;
    
    private ApiVersion() {
        super();
    }
    
    public final float getNO_VERSION() {
        return 0.0F;
    }
}