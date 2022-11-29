package com.bhi.commonlib.widgets;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007JP\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J2\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010!H\u0016R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/bhi/commonlib/widgets/CenteredImageSpan;", "Landroid/text/style/ImageSpan;", "context", "Landroid/content/Context;", "drawableResourceId", "", "verticalAlignment", "(Landroid/content/Context;II)V", "cachedDrawable", "Landroid/graphics/drawable/Drawable;", "getCachedDrawable", "()Landroid/graphics/drawable/Drawable;", "extraSpace", "initialDescent", "mDrawableRef", "Ljava/lang/ref/WeakReference;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "commonlib_dev"})
public final class CenteredImageSpan extends android.text.style.ImageSpan {
    private int initialDescent = 0;
    private int extraSpace = 0;
    private java.lang.ref.WeakReference<android.graphics.drawable.Drawable> mDrawableRef;
    
    @kotlin.jvm.JvmOverloads()
    public CenteredImageSpan(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @androidx.annotation.DrawableRes()
    int drawableResourceId) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads()
    public CenteredImageSpan(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @androidx.annotation.DrawableRes()
    int drawableResourceId, int verticalAlignment) {
        super(null);
    }
    
    private final android.graphics.drawable.Drawable getCachedDrawable() {
        return null;
    }
    
    @java.lang.Override()
    public void draw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas, @org.jetbrains.annotations.NotNull()
    java.lang.CharSequence text, int start, int end, float x, int top, int y, int bottom, @org.jetbrains.annotations.NotNull()
    android.graphics.Paint paint) {
    }
    
    @java.lang.Override()
    public int getSize(@org.jetbrains.annotations.NotNull()
    android.graphics.Paint paint, @org.jetbrains.annotations.NotNull()
    java.lang.CharSequence text, int start, int end, @org.jetbrains.annotations.Nullable()
    android.graphics.Paint.FontMetricsInt fm) {
        return 0;
    }
}