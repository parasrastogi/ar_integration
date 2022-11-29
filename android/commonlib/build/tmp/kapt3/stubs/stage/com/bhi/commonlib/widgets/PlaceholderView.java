package com.bhi.commonlib.widgets;

import java.lang.System;

/**
 * @author Rahul Rastogi
 *
 * This class shows a placeholder UI and hides associated content view on screens wherever data loading fails.
 * This placeholder can be shown in cases: during data loading, data loading success, data loading failure, no data found.
 *
 * Placeholder message and error drawable can be configured by user.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 d2\u00020\u0001:\u0001dB\'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\tB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\nB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u000bB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\fJ\"\u0010N\u001a\u0002052\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0012\u0010O\u001a\u0002052\b\u0010P\u001a\u0004\u0018\u00010QH\u0014J\u0010\u0010R\u001a\u0002052\b\b\u0001\u0010S\u001a\u00020\u0007J\u0010\u0010R\u001a\u0002052\b\b\u0002\u00100\u001a\u00020\u001dJ\u0010\u0010T\u001a\u0002052\b\b\u0001\u0010S\u001a\u00020\u0007J\u0010\u0010T\u001a\u0002052\b\b\u0002\u00100\u001a\u00020\u001dJ\u0006\u0010U\u001a\u000205J\u0010\u0010V\u001a\u0002052\b\b\u0001\u0010S\u001a\u00020\u0007J\u0010\u0010V\u001a\u0002052\b\b\u0002\u00100\u001a\u00020\u001dJ\u0010\u0010W\u001a\u0002052\u0006\u0010X\u001a\u00020\u0007H\u0002J\u0012\u0010Y\u001a\u0002052\b\u0010Z\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010[\u001a\u0002052\u0006\u0010\\\u001a\u00020]H\u0016J\b\u0010^\u001a\u000205H\u0002J\b\u0010 \u001a\u000205H\u0002J\u001a\u0010_\u001a\u0002052\u0006\u0010`\u001a\u00020a2\b\u0010\"\u001a\u0004\u0018\u00010\u001dH\u0002J\u000e\u0010b\u001a\u0002052\u0006\u0010c\u001a\u00020\u0007R\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0016@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R(\u0010\"\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0012\u001a\u0004\u0018\u00010\u001d@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R$\u0010%\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u000f\"\u0004\b\'\u0010\u0011R\u000e\u0010(\u001a\u00020)X\u0082.\u00a2\u0006\u0002\n\u0000R$\u0010*\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000f\"\u0004\b,\u0010\u0011R$\u0010-\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000f\"\u0004\b/\u0010\u0011R(\u00100\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0012\u001a\u0004\u0018\u00010\u001d@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001f\"\u0004\b2\u0010!R\"\u00103\u001a\n\u0012\u0004\u0012\u000205\u0018\u000104X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u000f\"\u0004\b<\u0010\u0011R\u001c\u0010=\u001a\u0004\u0018\u00010>X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u000e\u0010C\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020)X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010E\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010J\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR$\u0010K\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u000f\"\u0004\bM\u0010\u0011\u00a8\u0006e"}, d2 = {"Lcom/bhi/commonlib/widgets/PlaceholderView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "actionDrawableResId", "getActionDrawableResId", "()I", "setActionDrawableResId", "(I)V", "value", "actionDrawableTint", "getActionDrawableTint", "setActionDrawableTint", "Landroid/graphics/PorterDuff$Mode;", "actionDrawableTintMode", "getActionDrawableTintMode", "()Landroid/graphics/PorterDuff$Mode;", "setActionDrawableTintMode", "(Landroid/graphics/PorterDuff$Mode;)V", "actionMessage", "", "getActionMessage", "()Ljava/lang/String;", "setActionMessage", "(Ljava/lang/String;)V", "actionSecondaryMessage", "getActionSecondaryMessage", "setActionSecondaryMessage", "actionSecondaryTint", "getActionSecondaryTint", "setActionSecondaryTint", "contentView", "Landroid/view/View;", "currentState", "getCurrentState", "setCurrentState", "errorDrawableRes", "getErrorDrawableRes", "setErrorDrawableRes", "message", "getMessage", "setMessage", "onDescriptionClickListener", "Lkotlin/Function0;", "", "getOnDescriptionClickListener", "()Lkotlin/jvm/functions/Function0;", "setOnDescriptionClickListener", "(Lkotlin/jvm/functions/Function0;)V", "placeholderBackgroundColor", "getPlaceholderBackgroundColor", "setPlaceholderBackgroundColor", "placeholderBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "getPlaceholderBackgroundDrawable", "()Landroid/graphics/drawable/Drawable;", "setPlaceholderBackgroundDrawable", "(Landroid/graphics/drawable/Drawable;)V", "placeholderBackgroundRes", "placeholderContainerView", "placeholderTextColor", "getPlaceholderTextColor", "()Ljava/lang/Integer;", "setPlaceholderTextColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "tint", "getTint", "setTint", "initialize", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onLoading", "stringResId", "onLoadingFail", "onLoadingSuccess", "onNoDataFound", "onStateChange", "state", "onViewAdded", "child", "onWindowFocusChanged", "hasWindowFocus", "", "refreshViewTint", "setDescription", "textView", "Landroid/widget/TextView;", "setTitleTypeface", "typeface", "Companion", "commonlib_stage"})
public class PlaceholderView extends android.widget.FrameLayout {
    @org.jetbrains.annotations.NotNull()
    public static final com.bhi.commonlib.widgets.PlaceholderView.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_MESSAGE_PLACEHOLDER = "{{action_icon}}";
    public static final int STATE_SUCCESS = 1;
    public static final int STATE_FAIL = 2;
    public static final int STATE_LOADING = 3;
    public static final int STATE_NO_DATA_FOUND = 4;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onDescriptionClickListener;
    private android.view.View placeholderContainerView;
    private android.view.View contentView;
    private int placeholderBackgroundRes = 0;
    private int placeholderBackgroundColor = 0;
    @org.jetbrains.annotations.Nullable()
    private android.graphics.drawable.Drawable placeholderBackgroundDrawable;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer placeholderTextColor;
    private int actionDrawableResId = 0;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String actionMessage;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String message;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String actionSecondaryMessage;
    private int actionSecondaryTint = 0;
    private int errorDrawableRes = 0;
    private int tint = 0;
    @org.jetbrains.annotations.NotNull()
    private android.graphics.PorterDuff.Mode actionDrawableTintMode = android.graphics.PorterDuff.Mode.SRC_IN;
    private int actionDrawableTint = 0;
    private int currentState = 4;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnDescriptionClickListener() {
        return null;
    }
    
    public final void setOnDescriptionClickListener(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
    }
    
    public final int getPlaceholderBackgroundColor() {
        return 0;
    }
    
    public final void setPlaceholderBackgroundColor(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.drawable.Drawable getPlaceholderBackgroundDrawable() {
        return null;
    }
    
    public final void setPlaceholderBackgroundDrawable(@org.jetbrains.annotations.Nullable()
    android.graphics.drawable.Drawable p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getPlaceholderTextColor() {
        return null;
    }
    
    public final void setPlaceholderTextColor(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    public final int getActionDrawableResId() {
        return 0;
    }
    
    public final void setActionDrawableResId(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getActionMessage() {
        return null;
    }
    
    public final void setActionMessage(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMessage() {
        return null;
    }
    
    /**
     * Sets the message on placeholder view.
     */
    public final void setMessage(@org.jetbrains.annotations.Nullable()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getActionSecondaryMessage() {
        return null;
    }
    
    /**
     * Sets the description on placeholder view.
     */
    public final void setActionSecondaryMessage(@org.jetbrains.annotations.Nullable()
    java.lang.String value) {
    }
    
    public final int getActionSecondaryTint() {
        return 0;
    }
    
    /**
     * Changes color of action drawable.
     */
    public final void setActionSecondaryTint(int value) {
    }
    
    public final int getErrorDrawableRes() {
        return 0;
    }
    
    public final void setErrorDrawableRes(int value) {
    }
    
    public final int getTint() {
        return 0;
    }
    
    /**
     * Tint changes the text color of message and icon color of PlaceholderView.
     */
    public final void setTint(int value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.PorterDuff.Mode getActionDrawableTintMode() {
        return null;
    }
    
    /**
     * Sets tint mode for action drawable
     */
    public final void setActionDrawableTintMode(@org.jetbrains.annotations.NotNull()
    android.graphics.PorterDuff.Mode value) {
    }
    
    public final int getActionDrawableTint() {
        return 0;
    }
    
    /**
     * Changes color of action drawable.
     */
    public final void setActionDrawableTint(int value) {
    }
    
    public final int getCurrentState() {
        return 0;
    }
    
    /**
     * Changes the state of PlaceholderView programmatically.
     */
    public final void setCurrentState(int value) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.LOLLIPOP)
    public PlaceholderView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(null);
    }
    
    public PlaceholderView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    public PlaceholderView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    public PlaceholderView(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    private final void initialize(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) {
    }
    
    @java.lang.Override()
    public void onViewAdded(@org.jetbrains.annotations.Nullable()
    android.view.View child) {
    }
    
    public final void onLoading(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    public final void onLoading(@androidx.annotation.StringRes()
    int stringResId) {
    }
    
    public final void onLoadingSuccess() {
    }
    
    public final void onLoadingFail(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    public final void onLoadingFail(@androidx.annotation.StringRes()
    int stringResId) {
    }
    
    public final void onNoDataFound(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    public final void onNoDataFound(@androidx.annotation.StringRes()
    int stringResId) {
    }
    
    @java.lang.Override()
    protected void onConfigurationChanged(@org.jetbrains.annotations.Nullable()
    android.content.res.Configuration newConfig) {
    }
    
    private final void onStateChange(int state) {
    }
    
    @java.lang.Override()
    public void onWindowFocusChanged(boolean hasWindowFocus) {
    }
    
    private final void refreshViewTint() {
    }
    
    private final void setActionMessage() {
    }
    
    public final void setTitleTypeface(int typeface) {
    }
    
    private final void setDescription(android.widget.TextView textView, java.lang.String actionSecondaryMessage) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/bhi/commonlib/widgets/PlaceholderView$Companion;", "", "()V", "ACTION_MESSAGE_PLACEHOLDER", "", "STATE_FAIL", "", "STATE_LOADING", "STATE_NO_DATA_FOUND", "STATE_SUCCESS", "commonlib_stage"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}