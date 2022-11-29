package com.bhi.commonlib.util;

import java.lang.System;

/**
 * @author Rahul Rastogi
 *
 * Provides soft keyboard handling methods.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a8\u0006\n"}, d2 = {"Lcom/bhi/commonlib/util/MyKeyboard;", "", "()V", "hideKeyboard", "", "activity", "Landroid/app/Activity;", "showKeyboard", "editText", "Landroid/widget/EditText;", "commonlib_debug"})
public final class MyKeyboard {
    @org.jetbrains.annotations.NotNull()
    public static final com.bhi.commonlib.util.MyKeyboard INSTANCE = null;
    
    private MyKeyboard() {
        super();
    }
    
    public final void showKeyboard(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
    }
    
    public final void showKeyboard(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.Nullable()
    android.widget.EditText editText) {
    }
    
    public final void hideKeyboard(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
    }
}