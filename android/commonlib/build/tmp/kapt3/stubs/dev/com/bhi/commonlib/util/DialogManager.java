package com.bhi.commonlib.util;

import java.lang.System;

/**
 * @author Rahul Rastogi
 *
 *
 * A class for easing out some common dialog related operations.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0001 B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000f\u001a\u00020\u0004J\"\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J \u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J.\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0012Jn\u0010\u000e\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0003\u0010\u001d\u001a\u00020\u00042\b\b\u0003\u0010\u001e\u001a\u00020\u0004J\u000e\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006!"}, d2 = {"Lcom/bhi/commonlib/util/DialogManager;", "", "()V", "value", "", "tintColor", "getTintColor", "()I", "setTintColor", "(I)V", "getDialogWithoutProgress", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "getOkDialog", "resourceId", "messageResId", "onOkClickListener", "Landroid/content/DialogInterface$OnClickListener;", "title", "", "message", "onCancelClickListener", "Landroidx/appcompat/app/AlertDialog;", "canceledOnTouchOutside", "", "cancelable", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "positiveResId", "negativeResId", "getProgressDialog", "Companion", "commonlib_dev"})
public final class DialogManager {
    @org.jetbrains.annotations.NotNull()
    public static final com.bhi.commonlib.util.DialogManager.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.bhi.commonlib.util.DialogManager instance = null;
    private int tintColor = 0;
    
    private DialogManager() {
        super();
    }
    
    public final int getTintColor() {
        return 0;
    }
    
    public final void setTintColor(int value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Dialog getProgressDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Dialog getDialogWithoutProgress(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Dialog getOkDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @androidx.annotation.StringRes()
    int resourceId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Dialog getOkDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String message) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Dialog getOkDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    android.content.DialogInterface.OnClickListener onOkClickListener, @org.jetbrains.annotations.Nullable()
    android.content.DialogInterface.OnClickListener onCancelClickListener) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Dialog getOkDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @androidx.annotation.StringRes()
    int messageResId, @org.jetbrains.annotations.Nullable()
    android.content.DialogInterface.OnClickListener onOkClickListener) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Dialog getOkDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.Nullable()
    java.lang.String message) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.appcompat.app.AlertDialog getOkDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String title, @org.jetbrains.annotations.Nullable()
    java.lang.String message, boolean canceledOnTouchOutside, boolean cancelable, @org.jetbrains.annotations.Nullable()
    android.content.DialogInterface.OnClickListener onOkClickListener, @org.jetbrains.annotations.Nullable()
    android.content.DialogInterface.OnClickListener onCancelClickListener, @org.jetbrains.annotations.Nullable()
    android.content.DialogInterface.OnCancelListener onCancelListener, @androidx.annotation.StringRes()
    int positiveResId, @androidx.annotation.StringRes()
    int negativeResId) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/bhi/commonlib/util/DialogManager$Companion;", "", "()V", "instance", "Lcom/bhi/commonlib/util/DialogManager;", "getInstance", "()Lcom/bhi/commonlib/util/DialogManager;", "commonlib_dev"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.bhi.commonlib.util.DialogManager getInstance() {
            return null;
        }
    }
}