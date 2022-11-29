package com.bhi.commonlib.util;

import java.lang.System;

/**
 * Provides image url for resized url. This is helpful in loading image faster if we load only required size of image, not extra.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n\u00a8\u0006\f"}, d2 = {"Lcom/bhi/commonlib/util/ImageUrlResizer;", "", "()V", "getResizedImageUrl", "", "imageUrl", "maxSize", "", "getThumbnailUrl", "sizeMultiplier", "", "Companion", "commonlib_stage"})
public final class ImageUrlResizer {
    @org.jetbrains.annotations.NotNull()
    public static final com.bhi.commonlib.util.ImageUrlResizer.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MAX_HEIGHT = "maxheight";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MAX_WIDTH = "maxwidth";
    public static final int MAX_IMAGE_SIZE_ALLOWED = 1440;
    
    public ImageUrlResizer() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getResizedImageUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String imageUrl, int maxSize) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getThumbnailUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String imageUrl, float sizeMultiplier) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/bhi/commonlib/util/ImageUrlResizer$Companion;", "", "()V", "MAX_HEIGHT", "", "MAX_IMAGE_SIZE_ALLOWED", "", "MAX_WIDTH", "commonlib_stage"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}