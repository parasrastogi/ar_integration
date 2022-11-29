package com.app.homeViewer.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ \u0010\n\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/app/homeViewer/util/SceneFormUtil;", "", "()V", "getHitResult", "Lcom/google/ar/core/HitResult;", "frame", "Lcom/google/ar/core/Frame;", "x", "", "y", "isPlaneDetected", "", "isSceneFormSupported", "activity", "Landroid/app/Activity;", "HomeViewer_debug"})
public final class SceneFormUtil {
    @org.jetbrains.annotations.NotNull()
    public static final com.app.homeViewer.util.SceneFormUtil INSTANCE = null;
    
    private SceneFormUtil() {
        super();
    }
    
    public final boolean isSceneFormSupported(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
        return false;
    }
    
    public final boolean isPlaneDetected(@org.jetbrains.annotations.Nullable()
    com.google.ar.core.Frame frame, float x, float y) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.ar.core.HitResult getHitResult(@org.jetbrains.annotations.Nullable()
    com.google.ar.core.Frame frame, float x, float y) {
        return null;
    }
}