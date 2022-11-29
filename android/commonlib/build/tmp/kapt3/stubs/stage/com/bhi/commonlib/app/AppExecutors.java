package com.bhi.commonlib.app;

import java.lang.System;

/**
 * Holds background executors to perform specific background operations on their respective ExecutorService.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/bhi/commonlib/app/AppExecutors;", "", "()V", "POOL_EXECUTOR", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "getPOOL_EXECUTOR", "()Ljava/util/concurrent/ExecutorService;", "SINGLE_EXECUTOR", "getSINGLE_EXECUTOR", "THREAD_COUNT", "", "UI_EXECUTOR", "Ljava/util/concurrent/Executor;", "getUI_EXECUTOR", "()Ljava/util/concurrent/Executor;", "runOnUIThreadDelayed", "", "runnable", "Ljava/lang/Runnable;", "delayMS", "", "commonlib_stage"})
public final class AppExecutors {
    @org.jetbrains.annotations.NotNull()
    public static final com.bhi.commonlib.app.AppExecutors INSTANCE = null;
    private static final int THREAD_COUNT = 0;
    private static final java.util.concurrent.ExecutorService SINGLE_EXECUTOR = null;
    private static final java.util.concurrent.ExecutorService POOL_EXECUTOR = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.concurrent.Executor UI_EXECUTOR = null;
    
    private AppExecutors() {
        super();
    }
    
    public final java.util.concurrent.ExecutorService getSINGLE_EXECUTOR() {
        return null;
    }
    
    public final java.util.concurrent.ExecutorService getPOOL_EXECUTOR() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.concurrent.Executor getUI_EXECUTOR() {
        return null;
    }
    
    public final void runOnUIThreadDelayed(@org.jetbrains.annotations.NotNull()
    java.lang.Runnable runnable, long delayMS) {
    }
}