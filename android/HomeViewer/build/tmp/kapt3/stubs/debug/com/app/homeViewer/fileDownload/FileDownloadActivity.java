package com.app.homeViewer.fileDownload;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ,2\u00020\u0001:\u0003,-.B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0006H\u0002J\b\u0010#\u001a\u00020!H\u0002J\b\u0010$\u001a\u00020!H\u0002J\b\u0010%\u001a\u00020!H\u0002J\b\u0010&\u001a\u00020!H\u0014J\b\u0010\'\u001a\u00020!H\u0014J\u0012\u0010(\u001a\u00020!2\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\b\u0010+\u001a\u00020!H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0018\u00010\u0014R\u00020\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/app/homeViewer/fileDownload/FileDownloadActivity;", "Lcom/bhi/commonlib/util/BaseActivity;", "()V", "activityFileDownloadBinding", "Lcom/app/homeViewer/databinding/ActivityFileDownloadBinding;", "<set-?>", "", "bdxPlanId", "getBdxPlanId", "()I", "setBdxPlanId", "(I)V", "bdxPlanId$delegate", "Lkotlin/properties/ReadWriteProperty;", "currentModelDirectory", "Ljava/io/File;", "fileDownloadCallback", "Ljava/lang/ref/WeakReference;", "Lcom/app/homeViewer/fileDownload/FileDownloader$Callback;", "fileUnZipTask", "Lcom/app/homeViewer/fileDownload/FileDownloadActivity$FileUnZipTask;", "homeOnLotURL", "", "homeViewerURL", "homeViewerZipFile", "isShowingOnLot", "", "progressTint", "responseHandler", "Landroid/os/Handler;", "zipper", "Lcom/app/homeViewer/util/zip/Zipper;", "changeImage", "", "progress", "downloadRenderableFilesFromNetwork", "initDirectoryAndFiles", "moveToHomeViewerActivity", "onAppInBackground", "onAppInForeground", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "FileUnZipTask", "ZipFileDownloadCallback", "HomeViewer_debug"})
public final class FileDownloadActivity extends com.bhi.commonlib.util.BaseActivity {
    @org.jetbrains.annotations.NotNull()
    public static final com.app.homeViewer.fileDownload.FileDownloadActivity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_BDX_PLAN_ID = "bdx_plan_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_HOME_VIEWER_URL = "home_viewer_url";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_HOME_ON_LOT_URL = "home_on_lot_url";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_TINT_COLOR = "tint_color";
    private static final java.lang.String COMPRESSED_FILE_EXTENSION = ".zip";
    private com.app.homeViewer.util.zip.Zipper zipper;
    private com.app.homeViewer.fileDownload.FileDownloadActivity.FileUnZipTask fileUnZipTask;
    private boolean isShowingOnLot = false;
    private int progressTint = android.graphics.Color.BLACK;
    private final kotlin.properties.ReadWriteProperty bdxPlanId$delegate = null;
    private java.lang.String homeViewerURL;
    private java.lang.String homeOnLotURL;
    private java.io.File currentModelDirectory;
    private java.io.File homeViewerZipFile;
    private com.app.homeViewer.databinding.ActivityFileDownloadBinding activityFileDownloadBinding;
    private java.lang.ref.WeakReference<com.app.homeViewer.fileDownload.FileDownloader.Callback> fileDownloadCallback;
    private java.lang.ref.WeakReference<android.os.Handler> responseHandler;
    private java.util.HashMap _$_findViewCache;
    
    public FileDownloadActivity() {
        super();
    }
    
    private final int getBdxPlanId() {
        return 0;
    }
    
    private final void setBdxPlanId(int p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initDirectoryAndFiles() {
    }
    
    private final void downloadRenderableFilesFromNetwork() {
    }
    
    private final void moveToHomeViewerActivity() {
    }
    
    private final void changeImage(int progress) {
    }
    
    @java.lang.Override()
    protected void onAppInForeground() {
    }
    
    @java.lang.Override()
    protected void onAppInBackground() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @android.annotation.SuppressLint(value = {"StaticFieldLeak"})
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0083\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u00020\u00032\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0007\"\u0004\u0018\u00010\u0002H\u0014\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0014\u00a8\u0006\f"}, d2 = {"Lcom/app/homeViewer/fileDownload/FileDownloadActivity$FileUnZipTask;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "", "(Lcom/app/homeViewer/fileDownload/FileDownloadActivity;)V", "doInBackground", "params", "", "([Ljava/lang/Void;)Ljava/lang/Boolean;", "onPostExecute", "", "result", "HomeViewer_debug"})
    final class FileUnZipTask extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.lang.Boolean> {
        
        public FileUnZipTask() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        protected java.lang.Boolean doInBackground(@org.jetbrains.annotations.NotNull()
        java.lang.Void... params) {
            return null;
        }
        
        @java.lang.Override()
        protected void onPostExecute(boolean result) {
        }
    }
    
    /**
     * This callback gets called when the ZIP file download completes.
     */
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0014\u0010\u0005\u001a\u00020\u00042\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/app/homeViewer/fileDownload/FileDownloadActivity$ZipFileDownloadCallback;", "Lcom/app/homeViewer/fileDownload/FileDownloader$Callback;", "(Lcom/app/homeViewer/fileDownload/FileDownloadActivity;)V", "onDownloadCancel", "", "onDownloadFailure", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onDownloadSuccess", "onProgressUpdate", "progress", "", "HomeViewer_debug"})
    final class ZipFileDownloadCallback implements com.app.homeViewer.fileDownload.FileDownloader.Callback {
        
        public ZipFileDownloadCallback() {
            super();
        }
        
        @java.lang.Override()
        public void onProgressUpdate(int progress) {
        }
        
        @java.lang.Override()
        public void onDownloadSuccess() {
        }
        
        @java.lang.Override()
        public void onDownloadFailure(@org.jetbrains.annotations.NotNull()
        java.lang.Exception exception) {
        }
        
        @java.lang.Override()
        public void onDownloadCancel() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/app/homeViewer/fileDownload/FileDownloadActivity$Companion;", "", "()V", "COMPRESSED_FILE_EXTENSION", "", "KEY_BDX_PLAN_ID", "KEY_HOME_ON_LOT_URL", "KEY_HOME_VIEWER_URL", "KEY_TINT_COLOR", "HomeViewer_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}