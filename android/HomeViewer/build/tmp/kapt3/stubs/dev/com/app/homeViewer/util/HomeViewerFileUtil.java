package com.app.homeViewer.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/app/homeViewer/util/HomeViewerFileUtil;", "", "()V", "MAC_OS_ZIP_FILE_FOLDER", "", "RENDERABLE_FILE_EXTENSION", "getRoofRenderableFile", "Ljava/io/File;", "currentModelDirectory", "getStructureRenderableFile", "isRenderableFilesExist", "", "HomeViewer_dev"})
public final class HomeViewerFileUtil {
    @org.jetbrains.annotations.NotNull()
    public static final com.app.homeViewer.util.HomeViewerFileUtil INSTANCE = null;
    private static final java.lang.String RENDERABLE_FILE_EXTENSION = ".sfb";
    private static final java.lang.String MAC_OS_ZIP_FILE_FOLDER = "__MACOSX";
    
    private HomeViewerFileUtil() {
        super();
    }
    
    public final boolean isRenderableFilesExist(@org.jetbrains.annotations.NotNull()
    java.io.File currentModelDirectory) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.io.File getRoofRenderableFile(@org.jetbrains.annotations.NotNull()
    java.io.File currentModelDirectory) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.io.File getStructureRenderableFile(@org.jetbrains.annotations.NotNull()
    java.io.File currentModelDirectory) {
        return null;
    }
}