package com.bhi.commonlib.util;

import java.lang.System;

/**
 * @author Rahul Rastogi
 *
 * A utility class which helps in launching activities with lesser boilerplate code.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nJ*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\f2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nJ,\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0007J\u001e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\fJ(\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/bhi/commonlib/util/ActivityUtils;", "", "()V", "clearBackStackActivities", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "bundle", "Landroid/os/Bundle;", "activity", "Ljava/lang/Class;", "Landroid/app/Activity;", "startActivity", "activityClass", "data", "fragment", "Landroidx/fragment/app/Fragment;", "frag", "commonlib_debug"})
public final class ActivityUtils {
    @org.jetbrains.annotations.NotNull()
    public static final com.bhi.commonlib.util.ActivityUtils INSTANCE = null;
    
    private ActivityUtils() {
        super();
    }
    
    public final void startActivity(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment fragment, @org.jetbrains.annotations.NotNull()
    java.lang.Class<? extends android.app.Activity> activityClass) {
    }
    
    @kotlin.jvm.JvmOverloads()
    public final void startActivity(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.Class<? extends android.app.Activity> activityClass) {
    }
    
    @kotlin.jvm.JvmOverloads()
    public final void startActivity(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.Class<? extends android.app.Activity> activityClass, @org.jetbrains.annotations.Nullable()
    android.os.Bundle data) {
    }
    
    public final void startActivity(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment frag, @org.jetbrains.annotations.NotNull()
    java.lang.Class<? extends android.app.Activity> activityClass, @org.jetbrains.annotations.Nullable()
    android.os.Bundle data) {
    }
    
    public final void clearBackStackActivities(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.Class<? extends android.app.Activity> activity, @org.jetbrains.annotations.Nullable()
    android.os.Bundle bundle) {
    }
    
    public final void clearBackStackActivities(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.content.Intent intent, @org.jetbrains.annotations.Nullable()
    android.os.Bundle bundle) {
    }
}