package com.bhi.commonlib.util;

import java.lang.System;

/**
 * Provides helper methods for image manipulations.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rJ \u0010\u0016\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u000bJ&\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004\u00a8\u0006\u001c"}, d2 = {"Lcom/bhi/commonlib/util/ImageFileUtil;", "", "()V", "calculateInSampleSize", "", "options", "Landroid/graphics/BitmapFactory$Options;", "reqWidth", "reqHeight", "getImageOrientation", "currentImagePath", "", "rotateImage", "Landroid/graphics/Bitmap;", "source", "angle", "", "saveBitmap", "", "imageFile", "Ljava/io/File;", "bitmap", "savePublicImage", "context", "Landroid/content/Context;", "fileName", "scaleDownAndCompress", "maxFileLengthInBytes", "commonlib_debug"})
public final class ImageFileUtil {
    @org.jetbrains.annotations.NotNull()
    public static final com.bhi.commonlib.util.ImageFileUtil INSTANCE = null;
    
    private ImageFileUtil() {
        super();
    }
    
    public final boolean scaleDownAndCompress(@org.jetbrains.annotations.NotNull()
    java.io.File imageFile, int reqWidth, int reqHeight, int maxFileLengthInBytes) {
        return false;
    }
    
    private final int calculateInSampleSize(android.graphics.BitmapFactory.Options options, int reqWidth, int reqHeight) {
        return 0;
    }
    
    public final int getImageOrientation(@org.jetbrains.annotations.NotNull()
    java.lang.String currentImagePath) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.Bitmap rotateImage(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap source, float angle) {
        return null;
    }
    
    /**
     * Saves bitmap object in given imageFile path.
     */
    public final boolean saveBitmap(@org.jetbrains.annotations.NotNull()
    java.io.File imageFile, @org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String savePublicImage(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap, @org.jetbrains.annotations.NotNull()
    java.lang.String fileName) {
        return null;
    }
}