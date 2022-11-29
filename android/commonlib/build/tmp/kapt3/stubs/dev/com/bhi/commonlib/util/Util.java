package com.bhi.commonlib.util;

import java.lang.System;

/**
 * @author Rahul Rastogi
 *
 * A utility class provides some common methods.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00c0\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\nJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\nJ\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0015J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\nJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\nJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\nJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\nJ\u0010\u0010\"\u001a\u0004\u0018\u00010\n2\u0006\u0010#\u001a\u00020\nJ\u0010\u0010$\u001a\u0004\u0018\u00010\n2\u0006\u0010#\u001a\u00020\nJ\u000e\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020(J\u000e\u0010)\u001a\u00020\u00142\u0006\u0010\'\u001a\u00020(J\u000e\u0010*\u001a\u00020\u00142\u0006\u0010\'\u001a\u00020(J\u0006\u0010+\u001a\u00020&J\u0006\u0010,\u001a\u00020\u0014J\u001e\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020\u0014J\u0016\u00102\u001a\u00020\u00142\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/J\u000e\u00103\u001a\u00020\u00142\u0006\u00104\u001a\u000205J\"\u00106\u001a\u00020 2\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\u00142\n\b\u0002\u00109\u001a\u0004\u0018\u00010:J6\u00106\u001a\u00020 2\u0006\u0010;\u001a\u00020\n2\u0006\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020:2\u0006\u0010>\u001a\u00020:2\u0006\u0010?\u001a\u00020\u00142\u0006\u0010@\u001a\u00020\u0014J\u0010\u00106\u001a\u00020 2\b\u0010A\u001a\u0004\u0018\u00010\nJ\u000e\u0010B\u001a\u00020\u00142\u0006\u00104\u001a\u000205J&\u0010C\u001a\n\u0012\u0004\u0012\u0002HE\u0018\u00010D\"\u0004\b\u0000\u0010E2\u0010\u0010F\u001a\f\u0012\u0006\u0012\u0004\u0018\u0001HE\u0018\u00010DJ\u000e\u0010G\u001a\u00020H2\u0006\u0010<\u001a\u00020IJ\u000e\u0010J\u001a\u00020H2\u0006\u00104\u001a\u000205J\u0010\u0010K\u001a\u00020H2\b\u0010L\u001a\u0004\u0018\u00010\nJ\u0016\u0010M\u001a\u00020H2\u0006\u00104\u001a\u0002052\u0006\u0010N\u001a\u00020\nJ\u0010\u0010O\u001a\u00020H2\b\u0010P\u001a\u0004\u0018\u00010QJ\u0010\u0010R\u001a\u00020H2\b\u0010S\u001a\u0004\u0018\u00010\nJ)\u0010T\u001a\u00020\n\"\u0004\b\u0000\u0010E2\u0006\u0010U\u001a\u00020V2\u000e\u0010W\u001a\n\u0012\u0004\u0012\u0002HE\u0018\u00010X\u00a2\u0006\u0002\u0010YJ?\u0010Z\u001a\u00020[2\u0006\u00107\u001a\u00020\n2*\u0010\\\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020^0]0X\"\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020^0]\u00a2\u0006\u0002\u0010_JG\u0010Z\u001a\u00020[2\u0006\u00107\u001a\u00020\n2\u0006\u0010`\u001a\u00020\u00142*\u0010\\\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020^0]0X\"\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020^0]\u00a2\u0006\u0002\u0010aJ\u0016\u0010b\u001a\u00020\u00122\u0006\u0010c\u001a\u00020\u00122\u0006\u0010d\u001a\u00020\u0014J\u0016\u0010e\u001a\u00020f2\u0006\u0010\'\u001a\u00020(2\u0006\u00108\u001a\u00020\u0014J\u0016\u0010g\u001a\u00020f2\u0006\u0010\'\u001a\u00020(2\u0006\u00108\u001a\u00020\u0014J\u0018\u0010h\u001a\u00020f2\u0006\u0010\'\u001a\u00020(2\b\b\u0001\u0010i\u001a\u00020\u0014J.\u0010j\u001a\u00020f2\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020\n2\u0006\u0010n\u001a\u00020\n2\u0006\u0010o\u001a\u00020\u00142\u0006\u0010p\u001a\u00020\u0014J>\u0010j\u001a\u00020f2\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020\n2\u0006\u0010q\u001a\u00020\n2\u0006\u0010n\u001a\u00020\n2\u0006\u0010o\u001a\u00020\u00142\u0006\u0010r\u001a\u00020\u00142\u0006\u0010p\u001a\u00020\u0014J\u0016\u0010s\u001a\u00020f2\u0006\u00104\u001a\u0002052\u0006\u0010\u0017\u001a\u00020\nJ\u0016\u0010t\u001a\u00020f2\u0006\u00104\u001a\u0002052\u0006\u0010u\u001a\u00020\nJ\u001e\u0010v\u001a\u00020w2\u0006\u00107\u001a\u00020\n2\u0006\u0010x\u001a\u00020\u00122\u0006\u0010y\u001a\u00020\u0014J\u0010\u0010z\u001a\u00020{2\u0006\u0010|\u001a\u00020 H\u0002J\u000e\u0010}\u001a\u00020~2\u0006\u0010\u007f\u001a\u00020\u0012R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\u0080\u0001"}, d2 = {"Lcom/bhi/commonlib/util/Util;", "", "()V", "allowAllInputFilter", "Landroid/text/InputFilter;", "getAllowAllInputFilter", "()Landroid/text/InputFilter;", "personNameInputFilter", "getPersonNameInputFilter", "capitalizeFirstChar", "", "input", "capitalizeWords", "sentenceString", "extractDigits", "string", "formatNumber", "price", "", "maxFractionDigit", "", "", "formatPhoneNumber", "phoneNumber", "formatPrice", "formatPriceAndAppendKAtEnd", "formatServerDate", "date", "formatServerDateToMmDdYyyy", "formatUSAPhoneNumber", "rawPhone", "fromHtml", "Landroid/text/Spanned;", "htmlString", "getCommunityCodeArgumentName", "stringUrl", "getCommunityCodeFromCommunityUrl", "getDeviceDimension", "Lcom/bhi/commonlib/Dimension;", "activity", "Landroid/app/Activity;", "getDeviceHeight", "getDeviceMaxDimension", "getFullDeviceDimension", "getFullDeviceMaxDimension", "getMaxSpaceAvailableAtBottom", "parentView", "Landroid/view/View;", "anchorView", "topOffset", "getMaxSpaceAvailableAtTop", "getScreenDensity", "context", "Landroid/content/Context;", "getSpanned", "text", "color", "typeface", "Landroid/graphics/Typeface;", "title", "value", "titleFont", "valueFont", "titleColor", "valueColor", "stringText", "getStatusBarHeight", "handleUnCheckedCast", "", "T", "inList", "hasFraction", "", "", "hasPhoneCallFeature", "hasSpecialCharacter", "s", "isAppInstalled", "packageName", "isValidEmail", "target", "", "isVideoUrl", "url", "join", "delimiter", "", "arr", "", "(C[Ljava/lang/Object;)Ljava/lang/String;", "makeLinks", "Landroid/text/Spannable;", "links", "Lkotlin/Pair;", "Landroid/view/View$OnClickListener;", "(Ljava/lang/String;[Lkotlin/Pair;)Landroid/text/Spannable;", "linkTextColor", "(Ljava/lang/String;I[Lkotlin/Pair;)Landroid/text/Spannable;", "round", "number", "decimalPoint", "setStatusBarColor", "", "setStatusBarColorByColor", "setStatusBarColorRes", "colorResID", "setTextColors", "textView", "Landroid/widget/TextView;", "startText", "endText", "startColor", "endColor", "middleText", "middleColor", "showCallDialer", "showEmailApp", "emailId", "textToBitmap", "Landroid/graphics/Bitmap;", "textSize", "textColor", "trimSpannable", "Landroid/text/SpannableStringBuilder;", "spanned", "truncateTrailingZeros", "Ljava/math/BigDecimal;", "decimalString", "commonlib_dev"})
public final class Util {
    @org.jetbrains.annotations.NotNull()
    public static final com.bhi.commonlib.util.Util INSTANCE = null;
    @org.jetbrains.annotations.NotNull()
    private static final android.text.InputFilter personNameInputFilter = null;
    @org.jetbrains.annotations.NotNull()
    private static final android.text.InputFilter allowAllInputFilter = null;
    
    private Util() {
        super();
    }
    
    public final boolean isValidEmail(@org.jetbrains.annotations.Nullable()
    java.lang.CharSequence target) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Dimension getFullDeviceDimension() {
        return null;
    }
    
    public final int getFullDeviceMaxDimension() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.Dimension getDeviceDimension(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
        return null;
    }
    
    public final int getDeviceMaxDimension(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
        return 0;
    }
    
    public final int getDeviceHeight(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
        return 0;
    }
    
    public final int getScreenDensity(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return 0;
    }
    
    public final float round(float number, int decimalPoint) {
        return 0.0F;
    }
    
    public final boolean hasFraction(double value) {
        return false;
    }
    
    public final void setStatusBarColorRes(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @androidx.annotation.ColorRes()
    int colorResID) {
    }
    
    public final void setStatusBarColor(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, int color) {
    }
    
    public final void setStatusBarColorByColor(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, int color) {
    }
    
    public final int getStatusBarHeight(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String capitalizeFirstChar(@org.jetbrains.annotations.Nullable()
    java.lang.String input) {
        return null;
    }
    
    public final void setTextColors(@org.jetbrains.annotations.NotNull()
    android.widget.TextView textView, @org.jetbrains.annotations.NotNull()
    java.lang.String startText, @org.jetbrains.annotations.NotNull()
    java.lang.String endText, int startColor, int endColor) {
    }
    
    public final void setTextColors(@org.jetbrains.annotations.NotNull()
    android.widget.TextView textView, @org.jetbrains.annotations.NotNull()
    java.lang.String startText, @org.jetbrains.annotations.NotNull()
    java.lang.String middleText, @org.jetbrains.annotations.NotNull()
    java.lang.String endText, int startColor, int middleColor, int endColor) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>java.lang.String join(char delimiter, @org.jetbrains.annotations.Nullable()
    T[] arr) {
        return null;
    }
    
    public final void showCallDialer(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String phoneNumber) {
    }
    
    public final boolean isAppInstalled(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String packageName) {
        return false;
    }
    
    public final void showEmailApp(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String emailId) {
    }
    
    public final boolean hasPhoneCallFeature(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatPriceAndAppendKAtEnd(long price) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatPrice(long price) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatPrice(float price) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatNumber(float price, int maxFractionDigit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatNumber(long price) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String formatServerDate(@org.jetbrains.annotations.Nullable()
    java.lang.String date) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String formatServerDateToMmDdYyyy(@org.jetbrains.annotations.Nullable()
    java.lang.String date) {
        return null;
    }
    
    public final boolean isVideoUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String url) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String capitalizeWords(@org.jetbrains.annotations.Nullable()
    java.lang.String sentenceString) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String formatUSAPhoneNumber(@org.jetbrains.annotations.Nullable()
    java.lang.String rawPhone) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String formatPhoneNumber(@org.jetbrains.annotations.Nullable()
    java.lang.String phoneNumber) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.Bitmap textToBitmap(@org.jetbrains.annotations.NotNull()
    java.lang.String text, float textSize, int textColor) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.text.InputFilter getPersonNameInputFilter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.text.InputFilter getAllowAllInputFilter() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.text.Spanned fromHtml(@org.jetbrains.annotations.Nullable()
    java.lang.String htmlString) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCommunityCodeArgumentName(@org.jetbrains.annotations.NotNull()
    java.lang.String stringUrl) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCommunityCodeFromCommunityUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String stringUrl) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal truncateTrailingZeros(float decimalString) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.text.Spanned getSpanned(@org.jetbrains.annotations.Nullable()
    java.lang.String stringText) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.text.Spanned getSpanned(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String value, @org.jetbrains.annotations.NotNull()
    android.graphics.Typeface titleFont, @org.jetbrains.annotations.NotNull()
    android.graphics.Typeface valueFont, int titleColor, int valueColor) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.text.Spanned getSpanned(@org.jetbrains.annotations.NotNull()
    java.lang.String text, int color, @org.jetbrains.annotations.Nullable()
    android.graphics.Typeface typeface) {
        return null;
    }
    
    private final android.text.SpannableStringBuilder trimSpannable(android.text.Spanned spanned) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.text.Spannable makeLinks(@org.jetbrains.annotations.NotNull()
    java.lang.String text, int linkTextColor, @org.jetbrains.annotations.NotNull()
    kotlin.Pair<java.lang.String, ? extends android.view.View.OnClickListener>... links) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.text.Spannable makeLinks(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    kotlin.Pair<java.lang.String, ? extends android.view.View.OnClickListener>... links) {
        return null;
    }
    
    public final boolean hasSpecialCharacter(@org.jetbrains.annotations.Nullable()
    java.lang.String s) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final <T extends java.lang.Object>java.util.List<T> handleUnCheckedCast(@org.jetbrains.annotations.Nullable()
    java.util.List<? extends T> inList) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String extractDigits(@org.jetbrains.annotations.Nullable()
    java.lang.String string) {
        return null;
    }
    
    public final int getMaxSpaceAvailableAtBottom(@org.jetbrains.annotations.NotNull()
    android.view.View parentView, @org.jetbrains.annotations.NotNull()
    android.view.View anchorView, int topOffset) {
        return 0;
    }
    
    public final int getMaxSpaceAvailableAtTop(@org.jetbrains.annotations.NotNull()
    android.view.View parentView, @org.jetbrains.annotations.NotNull()
    android.view.View anchorView) {
        return 0;
    }
}