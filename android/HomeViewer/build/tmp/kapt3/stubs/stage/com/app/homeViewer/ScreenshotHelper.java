package com.app.homeViewer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JI\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00040\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fH\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/app/homeViewer/ScreenshotHelper;", "", "()V", "saveScreenshot", "", "arSceneView", "Lcom/google/ar/sceneform/SceneView;", "fileName", "", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "screenshotFile", "onError", "Lkotlin/Function0;", "HomeViewer_stage"})
public final class ScreenshotHelper {
    @org.jetbrains.annotations.NotNull()
    public static final com.app.homeViewer.ScreenshotHelper INSTANCE = null;
    
    private ScreenshotHelper() {
        super();
    }
    
    /**
     * As ArCore support isn't below android N. So, this method isn't going to be called below android-N
     * in any case.
     */
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    public final void saveScreenshot(@org.jetbrains.annotations.NotNull()
    com.google.ar.sceneform.SceneView arSceneView, @org.jetbrains.annotations.NotNull()
    java.lang.String fileName, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onError) {
    }
}