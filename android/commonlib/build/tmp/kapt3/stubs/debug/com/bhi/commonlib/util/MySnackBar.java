package com.bhi.commonlib.util;

import java.lang.System;

/**
 * @author Rahul Rastogi
 *
 * This is a utility class to use Snackbar UI component with ease from multiple screens.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\nJ \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nJU\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/bhi/commonlib/util/MySnackBar;", "", "()V", "make", "", "view", "Landroid/view/View;", "message", "", "duration", "", "messageResId", "", "actionTitle", "actionTintColor", "onActionClick", "Lkotlin/Function0;", "cancelable", "", "(Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;ZI)V", "commonlib_debug"})
public final class MySnackBar {
    @org.jetbrains.annotations.NotNull()
    public static final com.bhi.commonlib.util.MySnackBar INSTANCE = null;
    
    private MySnackBar() {
        super();
    }
    
    public final void make(@org.jetbrains.annotations.NotNull()
    android.view.View view, @androidx.annotation.StringRes()
    int messageResId) {
    }
    
    public final void make(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.NotNull()
    java.lang.CharSequence message) {
    }
    
    public final void make(@org.jetbrains.annotations.NotNull()
    android.view.View view, @androidx.annotation.StringRes()
    int messageResId, int duration) {
    }
    
    public final void make(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.NotNull()
    java.lang.CharSequence message, int duration) {
    }
    
    public final void make(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    java.lang.String actionTitle, @org.jetbrains.annotations.Nullable()
    java.lang.Integer actionTintColor, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> onActionClick, boolean cancelable, int duration) {
    }
}