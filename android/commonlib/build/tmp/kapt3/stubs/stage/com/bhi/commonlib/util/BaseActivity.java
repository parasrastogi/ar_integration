package com.bhi.commonlib.util;

import java.lang.System;

/**
 * @author Rahul Rastogi
 *
 * This class provides some common methods which may be used in almost every sub-class of AppCompatActivity class.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000 R2\u00020\u00012\u00020\u0002:\u0001RB\u0005\u00a2\u0006\u0002\u0010\u0003J\u001c\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0006\u0010\u0016\u001a\u00020\u0015J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0006\u0010\u0019\u001a\u00020\u0015J\u0006\u0010\u001a\u001a\u00020\u0015J\u0006\u0010\u001b\u001a\u00020\u0015J\u0006\u0010\u001c\u001a\u00020\u0015J\u0006\u0010\u001d\u001a\u00020\u0007J\u0006\u0010\u001e\u001a\u00020\u0007J\b\u0010\u001f\u001a\u00020\u0007H\u0004J\u0006\u0010 \u001a\u00020\u0007J\u0006\u0010!\u001a\u00020\u0007J\b\u0010\"\u001a\u00020\u0015H$J\b\u0010#\u001a\u00020\u0015H$J\b\u0010$\u001a\u00020\u0015H\u0016J\u0010\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\'H\u0016J\b\u0010(\u001a\u00020\u0015H\u0014J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020\u0015H\u0014J,\u0010-\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000b2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00132\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013H\u0016J\u001e\u00100\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000b2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013H\u0016J\b\u00102\u001a\u00020\u0015H\u0014J\b\u00103\u001a\u00020\u0015H\u0014J\u0010\u00104\u001a\u00020\u00152\b\u00105\u001a\u0004\u0018\u00010\u000fJ\u0010\u00106\u001a\u00020\u00152\b\b\u0001\u00107\u001a\u00020\u000bJ\u000e\u00106\u001a\u00020\u00152\u0006\u00108\u001a\u00020\u000fJ\u0006\u00109\u001a\u00020\u0015J\u0017\u0010:\u001a\u00020\u00152\n\b\u0003\u0010;\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010<J\u0018\u0010=\u001a\u00020\u00152\u0006\u0010>\u001a\u00020\u00072\b\b\u0001\u0010?\u001a\u00020\u000bJ\u0016\u0010=\u001a\u00020\u00152\u0006\u0010>\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u000fJ\u001a\u0010=\u001a\u00020\u00152\b\b\u0001\u0010@\u001a\u00020\u000b2\b\b\u0001\u0010?\u001a\u00020\u000bJ\u0018\u0010=\u001a\u00020\u00152\b\b\u0001\u0010@\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000fJ\u007f\u0010A\u001a\u00020\u00152\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u000f2\b\u0010B\u001a\u0004\u0018\u00010\u000f2\n\b\u0003\u0010C\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010D\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\n\b\u0003\u0010G\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010H\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010F2\b\b\u0002\u0010J\u001a\u00020\u00072\b\b\u0002\u0010K\u001a\u00020\u0007H\u0016\u00a2\u0006\u0002\u0010LJ2\u0010M\u001a\u00020\u00152\b\u0010B\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010K\u001a\u00020\u00072\n\b\u0002\u0010E\u001a\u0004\u0018\u00010FJ\u0019\u0010N\u001a\u00020\u00152\n\b\u0003\u0010O\u001a\u0004\u0018\u00010\u000bH\u0016\u00a2\u0006\u0002\u0010<J\u0012\u0010P\u001a\u00020\u00152\b\b\u0001\u0010Q\u001a\u00020\u000bH\u0004J\u0010\u0010P\u001a\u00020\u00152\u0006\u0010B\u001a\u00020\u000fH\u0004R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f0\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006S"}, d2 = {"Lcom/bhi/commonlib/util/BaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "()V", "dialog", "Landroid/app/Dialog;", "<set-?>", "", "isActivityResumed", "()Z", "requestCode", "", "requestPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "kotlin.jvm.PlatformType", "checkAndRequestPermissions", "permissionsList", "", "closeScreen", "", "dismissDialog", "getFragmentAtTop", "Landroidx/fragment/app/Fragment;", "hideActionBar", "hideActionBarLogo", "hideKeyboard", "hideProgressDialog", "isMobileDevice", "isNineInchTablet", "isNormallyCreated", "isSevenInchTablet", "isTablet", "onAppInBackground", "onAppInForeground", "onBackPressed", "onClick", "v", "Landroid/view/View;", "onDestroy", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onPause", "onPermissionsDenied", "grantedPermissionsList", "deniedPermissionsList", "onPermissionsGranted", "grantedPermissionList", "onResume", "onStart", "setActionBarLogo", "url", "setActionBarTitle", "titleRes", "title", "setOrientation", "setStatusBarColor", "colorResID", "(Ljava/lang/Integer;)V", "setupActionBar", "showBackIcon", "titleResource", "leftIconResource", "showDialog", "message", "positiveResId", "tintColorPositive", "onPositiveButtonClickListener", "Landroid/content/DialogInterface$OnClickListener;", "negativeResId", "tintColorNegative", "onNegativeButtonClickListener", "cancelOnTouchOutside", "isCancellable", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/Integer;Ljava/lang/Integer;Landroid/content/DialogInterface$OnClickListener;ZZ)V", "showOkDialog", "showProgressDialog", "tintColor", "showToast", "resId", "Companion", "commonlib_stage"})
public abstract class BaseActivity extends androidx.appcompat.app.AppCompatActivity implements android.view.View.OnClickListener {
    @org.jetbrains.annotations.NotNull()
    public static final com.bhi.commonlib.util.BaseActivity.Companion Companion = null;
    @org.jetbrains.annotations.Nullable()
    private static android.os.Handler stateHandler;
    @org.jetbrains.annotations.Nullable()
    private static java.lang.Runnable appInBackgroundRunnable;
    private android.app.Dialog dialog;
    private boolean isActivityResumed = false;
    private int requestCode = -1;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> requestPermissionLauncher = null;
    private java.util.HashMap _$_findViewCache;
    
    public BaseActivity() {
        super();
    }
    
    public final boolean isActivityResumed() {
        return false;
    }
    
    public void onPermissionsGranted(int requestCode, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> grantedPermissionList) {
    }
    
    public void onPermissionsDenied(int requestCode, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> grantedPermissionsList, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> deniedPermissionsList) {
    }
    
    public final boolean checkAndRequestPermissions(int requestCode, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> permissionsList) {
        return false;
    }
    
    protected final boolean isNormallyCreated() {
        return false;
    }
    
    public final void setOrientation() {
    }
    
    public final void dismissDialog() {
    }
    
    public void showProgressDialog(@org.jetbrains.annotations.Nullable()
    @androidx.annotation.ColorInt()
    java.lang.Integer tintColor) {
    }
    
    public final void hideProgressDialog() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    protected abstract void onAppInForeground();
    
    protected abstract void onAppInBackground();
    
    public final boolean isMobileDevice() {
        return false;
    }
    
    public final boolean isTablet() {
        return false;
    }
    
    public final boolean isSevenInchTablet() {
        return false;
    }
    
    public final boolean isNineInchTablet() {
        return false;
    }
    
    public final void hideActionBar() {
    }
    
    public final void setupActionBar(boolean showBackIcon, @org.jetbrains.annotations.NotNull()
    java.lang.String title) {
    }
    
    public final void setupActionBar(boolean showBackIcon, @androidx.annotation.StringRes()
    int titleResource) {
    }
    
    public final void setupActionBar(@androidx.annotation.DrawableRes()
    int leftIconResource, @androidx.annotation.StringRes()
    int titleResource) {
    }
    
    public final void setupActionBar(@androidx.annotation.DrawableRes()
    int leftIconResource, @org.jetbrains.annotations.NotNull()
    java.lang.String title) {
    }
    
    public final void setActionBarTitle(@androidx.annotation.StringRes()
    int titleRes) {
    }
    
    public final void setActionBarTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String title) {
    }
    
    public final void setActionBarLogo(@org.jetbrains.annotations.Nullable()
    java.lang.String url) {
    }
    
    protected final void showToast(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    protected final void showToast(@androidx.annotation.StringRes()
    int resId) {
    }
    
    public final void hideActionBarLogo() {
    }
    
    public final void setStatusBarColor(@org.jetbrains.annotations.Nullable()
    @androidx.annotation.ColorRes()
    java.lang.Integer colorResID) {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public androidx.fragment.app.Fragment getFragmentAtTop() {
        return null;
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    public void closeScreen() {
    }
    
    public final void hideKeyboard() {
    }
    
    public void showDialog(@org.jetbrains.annotations.Nullable()
    java.lang.String title, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    @androidx.annotation.StringRes()
    java.lang.Integer positiveResId, @org.jetbrains.annotations.Nullable()
    @androidx.annotation.ColorInt()
    java.lang.Integer tintColorPositive, @org.jetbrains.annotations.Nullable()
    android.content.DialogInterface.OnClickListener onPositiveButtonClickListener, @org.jetbrains.annotations.Nullable()
    @androidx.annotation.StringRes()
    java.lang.Integer negativeResId, @org.jetbrains.annotations.Nullable()
    @androidx.annotation.ColorInt()
    java.lang.Integer tintColorNegative, @org.jetbrains.annotations.Nullable()
    android.content.DialogInterface.OnClickListener onNegativeButtonClickListener, boolean cancelOnTouchOutside, boolean isCancellable) {
    }
    
    public final void showOkDialog(@org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.String title, boolean isCancellable, @org.jetbrains.annotations.Nullable()
    android.content.DialogInterface.OnClickListener onPositiveButtonClickListener) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/bhi/commonlib/util/BaseActivity$Companion;", "", "()V", "appInBackgroundRunnable", "Ljava/lang/Runnable;", "getAppInBackgroundRunnable", "()Ljava/lang/Runnable;", "setAppInBackgroundRunnable", "(Ljava/lang/Runnable;)V", "stateHandler", "Landroid/os/Handler;", "getStateHandler", "()Landroid/os/Handler;", "setStateHandler", "(Landroid/os/Handler;)V", "commonlib_stage"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.os.Handler getStateHandler() {
            return null;
        }
        
        public final void setStateHandler(@org.jetbrains.annotations.Nullable()
        android.os.Handler p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Runnable getAppInBackgroundRunnable() {
            return null;
        }
        
        public final void setAppInBackgroundRunnable(@org.jetbrains.annotations.Nullable()
        java.lang.Runnable p0) {
        }
    }
}