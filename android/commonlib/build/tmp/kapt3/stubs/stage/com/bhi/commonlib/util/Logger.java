package com.bhi.commonlib.util;

import java.lang.System;

/**
 * *
 * @author Rahul Rastogi
 *
 * Provides logging feature while debugging app. This class prints the class name in logs so that, it
 * finding out the logging class easily.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004J\u0016\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/bhi/commonlib/util/Logger;", "", "()V", "LOG_PREFIX", "", "MAX_LOG_CHAR_LIMIT", "", "isLogEnabled", "", "()Z", "setLogEnabled", "(Z)V", "d", "", "o", "msg", "e", "commonlib_stage"})
public final class Logger {
    @org.jetbrains.annotations.NotNull()
    public static final com.bhi.commonlib.util.Logger INSTANCE = null;
    private static final int MAX_LOG_CHAR_LIMIT = 4000;
    private static final java.lang.String LOG_PREFIX = "NHN::";
    private static boolean isLogEnabled = false;
    
    private Logger() {
        super();
    }
    
    public final boolean isLogEnabled() {
        return false;
    }
    
    public final void setLogEnabled(boolean p0) {
    }
    
    public final void d(@org.jetbrains.annotations.NotNull()
    java.lang.Object o, @org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
    
    public final void e(@org.jetbrains.annotations.NotNull()
    java.lang.Object o, @org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
}