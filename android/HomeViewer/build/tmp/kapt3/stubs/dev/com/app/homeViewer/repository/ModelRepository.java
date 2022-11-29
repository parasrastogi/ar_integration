package com.app.homeViewer.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/app/homeViewer/repository/ModelRepository;", "", "()V", "download3DModel", "Lcom/app/homeViewer/fileDownload/FileDownloader;", "responseHandler", "Ljava/lang/ref/WeakReference;", "Landroid/os/Handler;", "fileUrl", "", "file", "Ljava/io/File;", "callback", "Lcom/app/homeViewer/fileDownload/FileDownloader$Callback;", "Companion", "HomeViewer_dev"})
public final class ModelRepository {
    @org.jetbrains.annotations.NotNull()
    public static final com.app.homeViewer.repository.ModelRepository.Companion Companion = null;
    private static com.app.homeViewer.repository.ModelRepository instance;
    
    private ModelRepository() {
        super();
    }
    
    /**
     * Downloading model from network.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.app.homeViewer.fileDownload.FileDownloader download3DModel(@org.jetbrains.annotations.NotNull()
    java.lang.ref.WeakReference<android.os.Handler> responseHandler, @org.jetbrains.annotations.NotNull()
    java.lang.String fileUrl, @org.jetbrains.annotations.NotNull()
    java.io.File file, @org.jetbrains.annotations.NotNull()
    java.lang.ref.WeakReference<com.app.homeViewer.fileDownload.FileDownloader.Callback> callback) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/app/homeViewer/repository/ModelRepository$Companion;", "", "()V", "instance", "Lcom/app/homeViewer/repository/ModelRepository;", "getInstance", "HomeViewer_dev"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.app.homeViewer.repository.ModelRepository getInstance() {
            return null;
        }
    }
}