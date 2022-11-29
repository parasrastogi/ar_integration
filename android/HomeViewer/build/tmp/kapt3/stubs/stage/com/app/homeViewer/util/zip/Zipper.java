package com.app.homeViewer.util.zip;

import java.lang.System;

/**
 * Provides file/folder zip or un-zip features.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H&J*\u0010\t\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\f"}, d2 = {"Lcom/app/homeViewer/util/zip/Zipper;", "", "unZipFile", "Ljava/lang/Exception;", "Lkotlin/Exception;", "sourceZipFile", "", "destinationFolder", "password", "zipFile", "sourceFile", "destinationZipFile", "HomeViewer_stage"})
public abstract interface Zipper {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Exception zipFile(@org.jetbrains.annotations.NotNull()
    java.lang.String sourceFile, @org.jetbrains.annotations.NotNull()
    java.lang.String destinationZipFile, @org.jetbrains.annotations.Nullable()
    java.lang.String password);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Exception unZipFile(@org.jetbrains.annotations.NotNull()
    java.lang.String sourceZipFile, @org.jetbrains.annotations.NotNull()
    java.lang.String destinationFolder, @org.jetbrains.annotations.Nullable()
    java.lang.String password);
}