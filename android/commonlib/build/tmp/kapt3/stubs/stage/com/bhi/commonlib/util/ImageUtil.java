package com.bhi.commonlib.util;

import java.lang.System;

/**
 * @author Rahul Rastogi
 *
 * Provides image loading methods, either from web or disk storage.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u000201B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J8\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013JH\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0017JR\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00172\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0017Jn\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00172\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0017H\u0007J\u0018\u0010\u001f\u001a\u00020\b2\b\b\u0001\u0010 \u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\nJ\u0018\u0010!\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0015\u001a\u00020\nJ \u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\'H\u0002J:\u0010(\u001a\u00020)2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J\u001a\u0010*\u001a\u00020+2\u0006\u0010&\u001a\u00020\'2\b\b\u0001\u0010,\u001a\u00020\u0006H\u0002J(\u0010-\u001a\u00020\b2\u0006\u0010&\u001a\u00020\'2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010/R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u00062"}, d2 = {"Lcom/bhi/commonlib/util/ImageUtil;", "", "()V", "DEFAULT_DISK_CACHE_STRATEGY", "Lcom/bumptech/glide/load/engine/DiskCacheStrategy;", "UNKNOWN_THUMBNAIL_SIZE", "", "displayHighQualityImage", "", "thumbnailIV", "Landroid/widget/ImageView;", "progressView", "Landroid/view/View;", "subsamplingScaleImageView", "Lcom/davemorrissey/labs/subscaleview/SubsamplingScaleImageView;", "placeholderResID", "path", "", "thumbnailQuality", "Lcom/bhi/commonlib/util/ImageUtil$ThumbnailQuality;", "displayImage", "imageView", "centerCrop", "", "errorDrawableType", "Lcom/bhi/commonlib/util/ImageUtil$ErrorDrawableType;", "transitionAnimation", "circularImage", "targetWidth", "targetHeight", "diskCacheStrategy", "displayImageFromDrawableResource", "resId", "displayImageFromLocalUri", "uri", "getErrorBuilder", "Lcom/bumptech/glide/RequestBuilder;", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "getRequestOptions", "Lcom/bumptech/glide/request/RequestOptions;", "getResourceToUri", "Landroid/net/Uri;", "drawableId", "loadImage", "requestListener", "Lcom/bumptech/glide/request/RequestListener;", "ErrorDrawableType", "ThumbnailQuality", "commonlib_stage"})
public final class ImageUtil {
    @org.jetbrains.annotations.NotNull()
    public static final com.bhi.commonlib.util.ImageUtil INSTANCE = null;
    private static final int UNKNOWN_THUMBNAIL_SIZE = 10;
    private static final com.bumptech.glide.load.engine.DiskCacheStrategy DEFAULT_DISK_CACHE_STRATEGY = null;
    
    private ImageUtil() {
        super();
    }
    
    public final void displayImage(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.Nullable()
    java.lang.String path, int placeholderResID, boolean centerCrop, @org.jetbrains.annotations.NotNull()
    com.bhi.commonlib.util.ImageUtil.ThumbnailQuality thumbnailQuality, @org.jetbrains.annotations.NotNull()
    com.bhi.commonlib.util.ImageUtil.ErrorDrawableType errorDrawableType, boolean transitionAnimation) {
    }
    
    public final void displayImage(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.Nullable()
    java.lang.String path, int placeholderResID, boolean centerCrop, boolean circularImage, @org.jetbrains.annotations.NotNull()
    com.bhi.commonlib.util.ImageUtil.ThumbnailQuality thumbnailQuality, @org.jetbrains.annotations.NotNull()
    com.bhi.commonlib.util.ImageUtil.ErrorDrawableType errorDrawableType, boolean transitionAnimation) {
    }
    
    public final void loadImage(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String path, @org.jetbrains.annotations.Nullable()
    com.bumptech.glide.request.RequestListener<android.graphics.drawable.Drawable> requestListener) {
    }
    
    public final void displayImageFromLocalUri(@org.jetbrains.annotations.Nullable()
    java.lang.String uri, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView) {
    }
    
    public final void displayImageFromDrawableResource(@androidx.annotation.DrawableRes()
    int resId, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView) {
    }
    
    @android.annotation.SuppressLint(value = {"CheckResult"})
    public final void displayImage(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.Nullable()
    java.lang.String path, int placeholderResID, int targetWidth, int targetHeight, @org.jetbrains.annotations.NotNull()
    com.bumptech.glide.load.engine.DiskCacheStrategy diskCacheStrategy, boolean centerCrop, boolean circularImage, @org.jetbrains.annotations.NotNull()
    com.bhi.commonlib.util.ImageUtil.ThumbnailQuality thumbnailQuality, @org.jetbrains.annotations.NotNull()
    com.bhi.commonlib.util.ImageUtil.ErrorDrawableType errorDrawableType, boolean transitionAnimation) {
    }
    
    /**
     * Loads high quality images in SubsamplingScaleImageView.
     */
    public final void displayHighQualityImage(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView thumbnailIV, @org.jetbrains.annotations.NotNull()
    android.view.View progressView, @org.jetbrains.annotations.NotNull()
    com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView subsamplingScaleImageView, int placeholderResID, @org.jetbrains.annotations.Nullable()
    java.lang.String path, @org.jetbrains.annotations.NotNull()
    com.bhi.commonlib.util.ImageUtil.ThumbnailQuality thumbnailQuality) {
    }
    
    private final android.net.Uri getResourceToUri(android.content.Context context, @androidx.annotation.AnyRes()
    int drawableId) {
        return null;
    }
    
    private final com.bumptech.glide.request.RequestOptions getRequestOptions(int placeholderResID, boolean centerCrop, boolean circularImage, int targetWidth, int targetHeight, com.bumptech.glide.load.engine.DiskCacheStrategy diskCacheStrategy) {
        return null;
    }
    
    private final com.bumptech.glide.RequestBuilder<android.graphics.drawable.Drawable> getErrorBuilder(com.bhi.commonlib.util.ImageUtil.ErrorDrawableType errorDrawableType, android.content.Context context) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/bhi/commonlib/util/ImageUtil$ThumbnailQuality;", "", "sizeMultiplier", "", "(Ljava/lang/String;IF)V", "getSizeMultiplier", "()F", "NONE", "VERY_LOW", "LOW", "HIGH", "commonlib_stage"})
    public static enum ThumbnailQuality {
        /*public static final*/ NONE /* = new NONE(0.0F) */,
        /*public static final*/ VERY_LOW /* = new VERY_LOW(0.0F) */,
        /*public static final*/ LOW /* = new LOW(0.0F) */,
        /*public static final*/ HIGH /* = new HIGH(0.0F) */;
        private final float sizeMultiplier = 0.0F;
        
        ThumbnailQuality(float sizeMultiplier) {
        }
        
        public final float getSizeMultiplier() {
            return 0.0F;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/bhi/commonlib/util/ImageUtil$ErrorDrawableType;", "", "(Ljava/lang/String;I)V", "NONE", "CENTER_CROP", "CENTER_CROP_LONG", "commonlib_stage"})
    public static enum ErrorDrawableType {
        /*public static final*/ NONE /* = new NONE() */,
        /*public static final*/ CENTER_CROP /* = new CENTER_CROP() */,
        /*public static final*/ CENTER_CROP_LONG /* = new CENTER_CROP_LONG() */;
        
        ErrorDrawableType() {
        }
    }
}