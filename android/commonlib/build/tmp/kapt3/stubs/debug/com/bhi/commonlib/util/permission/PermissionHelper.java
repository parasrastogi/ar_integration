package com.bhi.commonlib.util.permission;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\'\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u001c\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\f\u00a8\u0006\r"}, d2 = {"Lcom/bhi/commonlib/util/permission/PermissionHelper;", "", "()V", "canRequestForBackgroundLocationPermission", "", "hasPermission", "context", "Landroid/content/Context;", "permissions", "", "", "(Landroid/content/Context;[Ljava/lang/String;)Z", "", "commonlib_debug"})
public final class PermissionHelper {
    @org.jetbrains.annotations.NotNull()
    public static final com.bhi.commonlib.util.permission.PermissionHelper INSTANCE = null;
    
    private PermissionHelper() {
        super();
    }
    
    public final boolean hasPermission(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> permissions) {
        return false;
    }
    
    public final boolean canRequestForBackgroundLocationPermission() {
        return false;
    }
    
    public final boolean hasPermission(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String... permissions) {
        return false;
    }
}