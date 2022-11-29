package com.bhi.commonlib.app;

import java.lang.System;

/**
 * This class handles app state handling when it gets started after being killed by android system due to several reasons like:
 * lack of memory, configuration change etc.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/bhi/commonlib/app/ProcessUtil;", "", "()V", "isAppProcessNormallyCreated", "", "()Z", "setAppProcessNormallyCreated", "(Z)V", "isNormalAppStartInProgress", "mainApplicationId", "", "getMainApplicationId", "()Ljava/lang/String;", "setMainApplicationId", "(Ljava/lang/String;)V", "onProcessNormallyCreated", "", "restartAppNormally", "activity", "Landroid/app/Activity;", "commonlib_debug"})
public final class ProcessUtil {
    @org.jetbrains.annotations.NotNull()
    public static final com.bhi.commonlib.app.ProcessUtil INSTANCE = null;
    
    /**
     * Must initialize this with the main application id.
     */
    public static java.lang.String mainApplicationId;
    
    /**
     * ProcessUtil#isAppStartManageInProgress() is a custom logic just to detect whether the app has been created normally or re-created after
     * process being killed by android system.
     */
    private static boolean isAppProcessNormallyCreated = false;
    private static boolean isNormalAppStartInProgress = false;
    
    private ProcessUtil() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMainApplicationId() {
        return null;
    }
    
    public final void setMainApplicationId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean isAppProcessNormallyCreated() {
        return false;
    }
    
    public final void setAppProcessNormallyCreated(boolean p0) {
    }
    
    public final void restartAppNormally(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
    }
    
    public final void onProcessNormallyCreated() {
    }
}