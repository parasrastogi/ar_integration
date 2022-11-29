package com.app.homeViewer.util.zip;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\f\u00a2\u0006\u0002\u0010\rJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0002H\u0014J\u0014\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0013H\u0014J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u001cH\u0014R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011\u00a8\u0006\u001d"}, d2 = {"Lcom/app/homeViewer/util/zip/InputStreamVolleyRequest;", "Lcom/android/volley/Request;", "", "method", "", "mUrl", "", "mListener", "Lcom/android/volley/Response$Listener;", "errorListener", "Lcom/android/volley/Response$ErrorListener;", "mParams", "", "(ILjava/lang/String;Lcom/android/volley/Response$Listener;Lcom/android/volley/Response$ErrorListener;Ljava/util/Map;)V", "getMParams", "()Ljava/util/Map;", "setMParams", "(Ljava/util/Map;)V", "responseHeaders", "", "getResponseHeaders", "setResponseHeaders", "deliverResponse", "", "response", "getParams", "parseNetworkResponse", "Lcom/android/volley/Response;", "Lcom/android/volley/NetworkResponse;", "HomeViewer_debug"})
public final class InputStreamVolleyRequest extends com.android.volley.Request<byte[]> {
    private final com.android.volley.Response.Listener<byte[]> mListener = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.Map<java.lang.String, java.lang.String> mParams;
    @org.jetbrains.annotations.Nullable()
    private java.util.Map<java.lang.String, java.lang.String> responseHeaders;
    
    public InputStreamVolleyRequest(int method, @org.jetbrains.annotations.NotNull()
    java.lang.String mUrl, @org.jetbrains.annotations.NotNull()
    com.android.volley.Response.Listener<byte[]> mListener, @org.jetbrains.annotations.NotNull()
    com.android.volley.Response.ErrorListener errorListener, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> mParams) {
        super(null, null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.String> getMParams() {
        return null;
    }
    
    public final void setMParams(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Map<java.lang.String, java.lang.String> getResponseHeaders() {
        return null;
    }
    
    public final void setResponseHeaders(@org.jetbrains.annotations.Nullable()
    java.util.Map<java.lang.String, java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.Throws(exceptionClasses = {com.android.volley.AuthFailureError.class})
    @java.lang.Override()
    protected java.util.Map<java.lang.String, java.lang.String> getParams() {
        return null;
    }
    
    @java.lang.Override()
    protected void deliverResponse(@org.jetbrains.annotations.NotNull()
    byte[] response) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected com.android.volley.Response<byte[]> parseNetworkResponse(@org.jetbrains.annotations.NotNull()
    com.android.volley.NetworkResponse response) {
        return null;
    }
}