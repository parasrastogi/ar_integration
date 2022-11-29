package com.app.homeViewer.fileDownload;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/app/homeViewer/fileDownload/DownloadDialog;", "", "builder", "Lcom/app/homeViewer/fileDownload/DownloadDialog$Builder;", "(Lcom/app/homeViewer/fileDownload/DownloadDialog$Builder;)V", "dismiss", "", "show", "updateProgress", "progress", "", "Builder", "HomeViewer_stage"})
public final class DownloadDialog {
    private final com.app.homeViewer.fileDownload.DownloadDialog.Builder builder = null;
    
    private DownloadDialog(com.app.homeViewer.fileDownload.DownloadDialog.Builder builder) {
        super();
    }
    
    public final void show() {
    }
    
    public final void updateProgress(int progress) {
    }
    
    public final void dismiss() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u000bJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\rJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u0010\u0016\u001a\u00020\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u000e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\u0019\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/app/homeViewer/fileDownload/DownloadDialog$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dialog", "Landroid/app/AlertDialog;", "message", "", "onCancelClick", "Lkotlin/Function0;", "", "progress", "", "progressBar", "Landroid/widget/ProgressBar;", "progressTint", "build", "Lcom/app/homeViewer/fileDownload/DownloadDialog;", "dismiss", "setMessage", "messageResId", "setOnCancelClickListener", "setProgress", "setProgressTint", "show", "HomeViewer_stage"})
    public static final class Builder {
        private final android.content.Context context = null;
        private java.lang.String message;
        private int progress = 0;
        private android.widget.ProgressBar progressBar;
        private android.app.AlertDialog dialog;
        private int progressTint = android.graphics.Color.BLACK;
        private kotlin.jvm.functions.Function0<kotlin.Unit> onCancelClick;
        
        public Builder(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.app.homeViewer.fileDownload.DownloadDialog.Builder setMessage(@org.jetbrains.annotations.NotNull()
        java.lang.String message) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.app.homeViewer.fileDownload.DownloadDialog.Builder setMessage(int messageResId) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.app.homeViewer.fileDownload.DownloadDialog.Builder setOnCancelClickListener(@org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function0<kotlin.Unit> onCancelClick) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.app.homeViewer.fileDownload.DownloadDialog.Builder setProgressTint(int progressTint) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.app.homeViewer.fileDownload.DownloadDialog build() {
            return null;
        }
        
        public final void show() {
        }
        
        public final void dismiss() {
        }
        
        public final void setProgress(int progress) {
        }
    }
}