package com.app.homeViewer.fileDownload;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/app/homeViewer/fileDownload/FileDownloaderCoroutines;", "", "()V", "isCancelled", "", "()Z", "setCancelled", "(Z)V", "downloadFile", "", "fileUrl", "", "file", "Ljava/io/File;", "callback", "Lcom/app/homeViewer/fileDownload/FileDownloaderCoroutines$Callback;", "Callback", "HomeViewer_stage"})
public final class FileDownloaderCoroutines {
    private boolean isCancelled = false;
    
    public FileDownloaderCoroutines() {
        super();
    }
    
    public final boolean isCancelled() {
        return false;
    }
    
    public final void setCancelled(boolean p0) {
    }
    
    public final void downloadFile(@org.jetbrains.annotations.NotNull()
    java.lang.String fileUrl, @org.jetbrains.annotations.NotNull()
    java.io.File file, @org.jetbrains.annotations.NotNull()
    com.app.homeViewer.fileDownload.FileDownloaderCoroutines.Callback callback) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0014\u0010\u0004\u001a\u00020\u00032\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/app/homeViewer/fileDownload/FileDownloaderCoroutines$Callback;", "", "onDownloadCancel", "", "onDownloadFailure", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onDownloadSuccess", "onProgressUpdate", "progress", "", "HomeViewer_stage"})
    public static abstract interface Callback {
        
        public abstract void onProgressUpdate(int progress);
        
        public abstract void onDownloadSuccess();
        
        public abstract void onDownloadFailure(@org.jetbrains.annotations.NotNull()
        java.lang.Exception exception);
        
        public abstract void onDownloadCancel();
    }
}