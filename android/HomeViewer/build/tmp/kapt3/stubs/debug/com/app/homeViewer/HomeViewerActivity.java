package com.app.homeViewer;

import java.lang.System;

@android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.N)
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0007\u0018\u0000 C2\u00020\u0001:\u0002CDB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u001fH\u0002J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\b\u0010$\u001a\u00020\u001fH\u0002J\b\u0010%\u001a\u00020\u0012H\u0002J\b\u0010&\u001a\u00020\u001fH\u0002J\b\u0010\'\u001a\u00020\u001fH\u0002J\b\u0010(\u001a\u00020\u001fH\u0002J\b\u0010)\u001a\u00020\u001fH\u0014J\b\u0010*\u001a\u00020\u001fH\u0014J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020-H\u0016J\u0012\u0010.\u001a\u00020\u001f2\b\u0010/\u001a\u0004\u0018\u000100H\u0014J,\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u00020\u00042\f\u00103\u001a\b\u0012\u0004\u0012\u000205042\f\u00106\u001a\b\u0012\u0004\u0012\u00020504H\u0016J\u001e\u00107\u001a\u00020\u001f2\u0006\u00102\u001a\u00020\u00042\f\u00108\u001a\b\u0012\u0004\u0012\u00020504H\u0016J\b\u00109\u001a\u00020\u001fH\u0002J\u0010\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u000205H\u0002J\b\u0010<\u001a\u00020\u001fH\u0002J\u0012\u0010=\u001a\u00020\u001f2\b\u0010>\u001a\u0004\u0018\u000105H\u0002J\b\u0010?\u001a\u00020\u001fH\u0002J\b\u0010@\u001a\u00020\u001fH\u0002J\b\u0010A\u001a\u00020\u001fH\u0002J\b\u0010B\u001a\u00020\u001fH\u0002R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006E"}, d2 = {"Lcom/app/homeViewer/HomeViewerActivity;", "Lcom/bhi/commonlib/util/BaseActivity;", "()V", "<set-?>", "", "bdxPlanId", "getBdxPlanId", "()I", "setBdxPlanId", "(I)V", "bdxPlanId$delegate", "Lkotlin/properties/ReadWriteProperty;", "currentModelDirectory", "Ljava/io/File;", "homeViewerArFragment", "Lcom/app/homeViewer/HorizontalPlaneArFragment;", "homeViewerZipFile", "isModelAdded", "", "isRoofAdded", "isShowingOnLot", "permissionRequested", "progressTint", "roofNode", "Lcom/google/ar/sceneform/Node;", "roofRenderable", "Lcom/google/ar/sceneform/rendering/ModelRenderable;", "selectedModelAnchorNode", "Lcom/google/ar/sceneform/AnchorNode;", "structureRenderable", "addModelInScene", "", "attemptTakingScreenshot", "deleteModelFromDisk", "getAnchor", "Lcom/google/ar/core/Anchor;", "initDirectoryAndFiles", "isPlaneDetected", "loadRenderableFiles", "loadRoofRenderable", "loadStructureRenderable", "onAppInBackground", "onAppInForeground", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPermissionsDenied", "requestCode", "grantedPermissionsList", "", "", "deniedPermissionsList", "onPermissionsGranted", "grantedPermissionList", "onScreenshotError", "onScreenshotSuccess", "imageFile", "removeModel", "setMessage", "message", "showDeleteModelConfirmation", "takeScreenshot", "toggleModel", "toggleRoof", "Companion", "OnFrameUpdateListener", "HomeViewer_debug"})
public final class HomeViewerActivity extends com.bhi.commonlib.util.BaseActivity {
    @org.jetbrains.annotations.NotNull()
    public static final com.app.homeViewer.HomeViewerActivity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_BDX_PLAN_ID = "bdx_plan_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IS_SHOWING_ON_LOT = "is_showing_on_lot";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_TINT_COLOR = "tint_color";
    private static final java.lang.String COMPRESSED_FILE_EXTENSION = ".zip";
    private static final int RC_HOME_VIEWER_PERMISSIONS = 101;
    private static final int RC_SCREENSHOT_PERMISSIONS = 102;
    private static final java.util.List<java.lang.String> REQUIRED_PERMISSIONS = null;
    private final kotlin.properties.ReadWriteProperty bdxPlanId$delegate = null;
    private boolean permissionRequested = false;
    private boolean isShowingOnLot = false;
    private int progressTint = android.graphics.Color.BLACK;
    private com.app.homeViewer.HorizontalPlaneArFragment homeViewerArFragment;
    private com.google.ar.sceneform.rendering.ModelRenderable structureRenderable;
    private com.google.ar.sceneform.rendering.ModelRenderable roofRenderable;
    private com.google.ar.sceneform.AnchorNode selectedModelAnchorNode;
    private com.google.ar.sceneform.Node roofNode;
    private java.io.File currentModelDirectory;
    private java.io.File homeViewerZipFile;
    private boolean isModelAdded = false;
    private boolean isRoofAdded = false;
    private java.util.HashMap _$_findViewCache;
    
    public HomeViewerActivity() {
        super();
    }
    
    private final int getBdxPlanId() {
        return 0;
    }
    
    private final void setBdxPlanId(int p0) {
    }
    
    @java.lang.Override()
    protected void onAppInForeground() {
    }
    
    @java.lang.Override()
    protected void onAppInBackground() {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initDirectoryAndFiles() {
    }
    
    @java.lang.Override()
    public void onPermissionsGranted(int requestCode, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> grantedPermissionList) {
    }
    
    @java.lang.Override()
    public void onPermissionsDenied(int requestCode, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> grantedPermissionsList, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> deniedPermissionsList) {
    }
    
    private final void loadRenderableFiles() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    private final void loadRoofRenderable() {
    }
    
    private final void loadStructureRenderable() {
    }
    
    private final void toggleModel() {
    }
    
    private final void addModelInScene() {
    }
    
    private final boolean isPlaneDetected() {
        return false;
    }
    
    /**
     * Provides anchor from center of screen, if possible.
     */
    private final com.google.ar.core.Anchor getAnchor() {
        return null;
    }
    
    private final void toggleRoof() {
    }
    
    private final void removeModel() {
    }
    
    private final void showDeleteModelConfirmation() {
    }
    
    private final void deleteModelFromDisk() {
    }
    
    private final void attemptTakingScreenshot() {
    }
    
    private final void takeScreenshot() {
    }
    
    private final void onScreenshotSuccess(java.lang.String imageFile) {
    }
    
    private final void onScreenshotError() {
    }
    
    private final void setMessage(java.lang.String message) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/app/homeViewer/HomeViewerActivity$OnFrameUpdateListener;", "Lcom/google/ar/sceneform/Scene$OnUpdateListener;", "(Lcom/app/homeViewer/HomeViewerActivity;)V", "onUpdate", "", "frameTime", "Lcom/google/ar/sceneform/FrameTime;", "HomeViewer_debug"})
    final class OnFrameUpdateListener implements com.google.ar.sceneform.Scene.OnUpdateListener {
        
        public OnFrameUpdateListener() {
            super();
        }
        
        @java.lang.Override()
        public void onUpdate(@org.jetbrains.annotations.Nullable()
        com.google.ar.sceneform.FrameTime frameTime) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/app/homeViewer/HomeViewerActivity$Companion;", "", "()V", "COMPRESSED_FILE_EXTENSION", "", "IS_SHOWING_ON_LOT", "KEY_BDX_PLAN_ID", "KEY_TINT_COLOR", "RC_HOME_VIEWER_PERMISSIONS", "", "RC_SCREENSHOT_PERMISSIONS", "REQUIRED_PERMISSIONS", "", "HomeViewer_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}