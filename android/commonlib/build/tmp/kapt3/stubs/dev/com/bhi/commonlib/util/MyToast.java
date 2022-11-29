package com.bhi.commonlib.util;

import java.lang.System;

/**
 * @author Rahul Rastogi
 *
 * A utility class helps in displaying custom Toast messages.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u0007J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\bH\u0007J\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/bhi/commonlib/util/MyToast;", "", "()V", "makeText", "", "context", "Landroid/content/Context;", "stringResourceId", "", "duration", "text", "", "gravity", "makeTextAbove", "view", "Landroid/view/View;", "commonlib_dev"})
public final class MyToast {
    @org.jetbrains.annotations.NotNull()
    public static final com.bhi.commonlib.util.MyToast INSTANCE = null;
    
    private MyToast() {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public final void makeText(@org.jetbrains.annotations.NotNull()
    android.content.Context context, int stringResourceId) {
    }
    
    @kotlin.jvm.JvmOverloads()
    public final void makeText(@org.jetbrains.annotations.NotNull()
    android.content.Context context, int stringResourceId, int duration) {
    }
    
    @kotlin.jvm.JvmOverloads()
    public final void makeText(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    @kotlin.jvm.JvmOverloads()
    public final void makeText(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String text, int duration) {
    }
    
    @kotlin.jvm.JvmOverloads()
    public final void makeText(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String text, int duration, int gravity) {
    }
    
    public final void makeTextAbove(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
}