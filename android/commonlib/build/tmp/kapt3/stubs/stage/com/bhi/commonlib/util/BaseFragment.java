package com.bhi.commonlib.util;

import java.lang.System;

/**
 * @author Rahul Rastogi.
 *
 * Provides some basic methods to all sub-classes of Fragment class.
 * It must be used only if related Activity is inherited from BaseActivity class.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J&\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00112\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u000bJ\b\u0010 \u001a\u00020!H\u0004J\b\u0010\"\u001a\u00020!H\u0004J\b\u0010#\u001a\u00020!H\u0004J\u0006\u0010\u000f\u001a\u00020\u000bJ\b\u0010$\u001a\u00020\u000bH\u0004J\b\u0010%\u001a\u00020\u000bH\u0004J\u0010\u0010&\u001a\u00020!2\u0006\u0010\'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u000bH\u0016J\u0010\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020!H\u0016J\b\u0010.\u001a\u00020!H\u0016J\b\u0010/\u001a\u00020!H\u0016J,\u00100\u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u00112\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00190\u001e2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00190\u001eH\u0016J\u001e\u00103\u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u00112\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00190\u001eH\u0016J\b\u00105\u001a\u00020!H\u0016J\u000e\u00106\u001a\u00020!2\u0006\u00107\u001a\u00020\tJ\u000e\u00108\u001a\u00020!2\u0006\u00107\u001a\u00020\tJu\u00109\u001a\u00020!2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00192\b\u0010;\u001a\u0004\u0018\u00010\u00192\n\b\u0003\u0010<\u001a\u0004\u0018\u00010\u00112\n\b\u0003\u0010=\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?2\n\b\u0003\u0010@\u001a\u0004\u0018\u00010\u00112\n\b\u0003\u0010A\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010B\u001a\u0004\u0018\u00010?2\b\b\u0002\u0010C\u001a\u00020\u000bH\u0016\u00a2\u0006\u0002\u0010DJ\u001c\u0010E\u001a\u00020!2\b\u0010;\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0019J\u0019\u0010F\u001a\u00020!2\n\b\u0003\u0010G\u001a\u0004\u0018\u00010\u0011H\u0016\u00a2\u0006\u0002\u0010HJ\u0012\u0010I\u001a\u00020!2\b\b\u0001\u0010J\u001a\u00020\u0011H\u0004J\u0012\u0010I\u001a\u00020!2\b\u0010;\u001a\u0004\u0018\u00010\u0019H\u0004R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0011X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\u0016\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00190\u00190\u00180\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006K"}, d2 = {"Lcom/bhi/commonlib/util/BaseFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "Lcom/bhi/commonlib/util/OnBackPressed;", "()V", "alertDialog", "Landroid/app/Dialog;", "attachSafeRunnable", "", "Ljava/lang/Runnable;", "isAttached", "", "()Z", "setAttached", "(Z)V", "isInResumeState", "locationRequestCode", "", "getLocationRequestCode", "()I", "progressBarDialog", "requestCode", "requestPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "kotlin.jvm.PlatformType", "viewPostRunnable", "checkAndRequestPermissions", "permissionsList", "", "requestPermission", "dismissAlertDialog", "", "dismissProgressDialog", "hideKeyboard", "isNormallyCreated", "isTablet", "onAttach", "context", "Landroid/content/Context;", "onBackPressed", "onClick", "v", "Landroid/view/View;", "onDestroyView", "onDetach", "onPause", "onPermissionsDenied", "grantedPermissionsList", "deniedPermissionsList", "onPermissionsGranted", "grantedPermissionList", "onResume", "setAttachSafeRunnable", "runnable", "setViewPostRunnable", "showAlertDialog", "title", "message", "positiveResId", "tintColorPositive", "onPositiveButtonClickListener", "Landroid/content/DialogInterface$OnClickListener;", "negativeResId", "tintColorNegative", "onNegativeButtonClickListener", "cancelOnTouchOutside", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/Integer;Ljava/lang/Integer;Landroid/content/DialogInterface$OnClickListener;Z)V", "showOkDialog", "showProgressDialog", "tintColor", "(Ljava/lang/Integer;)V", "showToast", "resId", "commonlib_stage"})
public class BaseFragment extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener, com.bhi.commonlib.util.OnBackPressed {
    private boolean isInResumeState = false;
    private boolean isAttached = false;
    private final java.util.List<java.lang.Runnable> attachSafeRunnable = null;
    private java.lang.Runnable viewPostRunnable;
    private android.app.Dialog alertDialog;
    private android.app.Dialog progressBarDialog;
    private int requestCode = -1;
    private final int locationRequestCode = 10001;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> requestPermissionLauncher = null;
    private java.util.HashMap _$_findViewCache;
    
    public BaseFragment() {
        super();
    }
    
    protected final boolean isAttached() {
        return false;
    }
    
    protected final void setAttached(boolean p0) {
    }
    
    public final int getLocationRequestCode() {
        return 0;
    }
    
    public void onPermissionsGranted(int requestCode, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> grantedPermissionList) {
    }
    
    public void onPermissionsDenied(int requestCode, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> grantedPermissionsList, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> deniedPermissionsList) {
    }
    
    public final boolean checkAndRequestPermissions(int requestCode, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> permissionsList, boolean requestPermission) {
        return false;
    }
    
    protected final boolean isNormallyCreated() {
        return false;
    }
    
    public final void setAttachSafeRunnable(@org.jetbrains.annotations.NotNull()
    java.lang.Runnable runnable) {
    }
    
    public final void setViewPostRunnable(@org.jetbrains.annotations.NotNull()
    java.lang.Runnable runnable) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    protected final void showToast(@org.jetbrains.annotations.Nullable()
    java.lang.String message) {
    }
    
    protected final void showToast(@androidx.annotation.StringRes()
    int resId) {
    }
    
    protected final boolean isTablet() {
        return false;
    }
    
    public final boolean isInResumeState() {
        return false;
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    @java.lang.Override()
    public void onDetach() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    protected final void dismissAlertDialog() {
    }
    
    protected final void dismissProgressDialog() {
    }
    
    public void showProgressDialog(@org.jetbrains.annotations.Nullable()
    @androidx.annotation.ColorInt()
    java.lang.Integer tintColor) {
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public void showAlertDialog(@org.jetbrains.annotations.Nullable()
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
    android.content.DialogInterface.OnClickListener onNegativeButtonClickListener, boolean cancelOnTouchOutside) {
    }
    
    public final void showOkDialog(@org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.String title) {
    }
    
    protected final void hideKeyboard() {
    }
    
    @java.lang.Override()
    public boolean onBackPressed() {
        return false;
    }
}