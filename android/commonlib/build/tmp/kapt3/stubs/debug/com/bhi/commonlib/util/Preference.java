package com.bhi.commonlib.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u000fJ \u0010\u000e\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\f\u001a\u00020\rH\u0002J%\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0002\u0010\u0017J%\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0002\u0010\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/bhi/commonlib/util/Preference;", "", "()V", "BIOMETRIC_ENABLED", "", "FIRST_TIME_PERMISSION", "IS_DIALOG_ALREADY_SHOWED", "LOGIN_SESSION_COUNT", "NEVER_CLICKED", "REMIND_ME_LATER_CLICKED", "clearPreference", "", "mContext", "Landroid/content/Context;", "getPreferences", "", "key", "defaultValue", "", "getSharedPreferences", "Landroid/content/SharedPreferences;", "setPreferences", "value", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Boolean;)V", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Integer;)V", "commonlib_debug"})
public final class Preference {
    @org.jetbrains.annotations.NotNull()
    public static final com.bhi.commonlib.util.Preference INSTANCE = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FIRST_TIME_PERMISSION = "first_time_permission";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String REMIND_ME_LATER_CLICKED = "remind_me_later_clicked";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NEVER_CLICKED = "never_clicked";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IS_DIALOG_ALREADY_SHOWED = "is_dialog_already_showed";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LOGIN_SESSION_COUNT = "login_session_count";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BIOMETRIC_ENABLED = "biometric_enabled";
    
    private Preference() {
        super();
    }
    
    private final android.content.SharedPreferences getSharedPreferences(android.content.Context mContext) {
        return null;
    }
    
    public final void setPreferences(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, @org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean value) {
    }
    
    public final boolean getPreferences(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, @org.jetbrains.annotations.NotNull()
    java.lang.String key, boolean defaultValue) {
        return false;
    }
    
    public final void setPreferences(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, @org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.Nullable()
    java.lang.Integer value) {
    }
    
    public final int getPreferences(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, @org.jetbrains.annotations.NotNull()
    java.lang.String key, int defaultValue) {
        return 0;
    }
    
    public final void clearPreference(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext) {
    }
}