package com.bhi.commonlib.util

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import androidx.annotation.AnyRes
import androidx.annotation.DrawableRes
import com.bhi.commonlib.R
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import com.bumptech.glide.request.transition.Transition
import com.davemorrissey.labs.subscaleview.ImageSource
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView


/**
 * @author Rahul Rastogi
 *
 * Provides image loading methods, either from web or disk storage.
 */
object ImageUtil {

    private const val UNKNOWN_THUMBNAIL_SIZE = 10 //pixel

    enum class ThumbnailQuality(val sizeMultiplier: Float) {
        NONE(0f),
        VERY_LOW(0.0125f),
        LOW(0.04f), //2.5%
        HIGH(0.1f) //10%
    }

    enum class ErrorDrawableType {
        NONE,
        CENTER_CROP,
        CENTER_CROP_LONG
    }

    private val DEFAULT_DISK_CACHE_STRATEGY = DiskCacheStrategy.ALL!!

    fun displayImage(imageView: ImageView, path: String?, placeholderResID: Int, centerCrop: Boolean = false,
                     thumbnailQuality: ThumbnailQuality = ThumbnailQuality.NONE, errorDrawableType: ErrorDrawableType = ErrorDrawableType.CENTER_CROP, transitionAnimation: Boolean = true) {
        displayImage(imageView, path, placeholderResID, 0, 0, DEFAULT_DISK_CACHE_STRATEGY, centerCrop, false, thumbnailQuality, errorDrawableType, transitionAnimation)
    }

    fun displayImage(imageView: ImageView, path: String?, placeholderResID: Int, centerCrop: Boolean = false, circularImage: Boolean = false,
                     thumbnailQuality: ThumbnailQuality = ThumbnailQuality.NONE, errorDrawableType: ErrorDrawableType = ErrorDrawableType.CENTER_CROP, transitionAnimation: Boolean = true) {
        displayImage(imageView, path, placeholderResID, 0, 0, DEFAULT_DISK_CACHE_STRATEGY, centerCrop, circularImage, thumbnailQuality, errorDrawableType, transitionAnimation)
    }

    fun loadImage(context: Context, path: String?, requestListener: RequestListener<Drawable>?) {
        Glide.with(context)
                .load(path)
                .listener(requestListener).preload()
    }

    fun displayImageFromLocalUri(uri: String?, imageView: ImageView) {
        Glide.with(imageView.context)
                .load(uri)
                .into(imageView)
    }

    fun displayImageFromDrawableResource(@DrawableRes resId: Int, imageView: ImageView) {
        Glide.with(imageView.context)
                .load(resId)
                .into(imageView)
    }

    @SuppressLint("CheckResult")
    fun displayImage(imageView: ImageView, path: String?, placeholderResID: Int,
                     targetWidth: Int = 0, targetHeight: Int = 0, diskCacheStrategy: DiskCacheStrategy = DEFAULT_DISK_CACHE_STRATEGY,
                     centerCrop: Boolean, circularImage: Boolean = false, thumbnailQuality: ThumbnailQuality = ThumbnailQuality.NONE, errorDrawableType: ErrorDrawableType, transitionAnimation: Boolean = true) {

        val requestOptions = getRequestOptions(placeholderResID, centerCrop, circularImage, targetWidth, targetHeight, diskCacheStrategy)
        val errorRequestBuilder = getErrorBuilder(errorDrawableType, imageView.context)

        val drawableRequestBuilder = Glide
                .with(imageView.context)
                .load(path)
                .error(errorRequestBuilder)

        if (transitionAnimation) {
            drawableRequestBuilder.transition(withCrossFade(DrawableCrossFadeFactory.Builder(700).setCrossFadeEnabled(false).build()))
        }

        //Checking for thumbnail loading before loading actual image.
        if (!TextUtils.isEmpty(path) && thumbnailQuality != ThumbnailQuality.NONE) {
            val thumbnailUrl = ImageUrlResizer().getThumbnailUrl(path, thumbnailQuality.sizeMultiplier)

            if (TextUtils.isEmpty(thumbnailUrl)) {
                drawableRequestBuilder.thumbnail(thumbnailQuality.sizeMultiplier)
            } else {
                val thumbnailRequest = Glide.with(imageView.context)
                        .load(thumbnailUrl)
                        .apply(requestOptions)
                drawableRequestBuilder.thumbnail(thumbnailRequest)
            }
        }

        drawableRequestBuilder
                .apply(requestOptions)
                .into(imageView)
    }

    /**
     * Loads high quality images in SubsamplingScaleImageView.
     */
    fun displayHighQualityImage(thumbnailIV: ImageView, progressView: View, subsamplingScaleImageView: SubsamplingScaleImageView,
                                placeholderResID: Int, path: String?, thumbnailQuality: ThumbnailQuality) {
        progressView.visibility = View.VISIBLE
        thumbnailIV.visibility = View.VISIBLE

        var thumbnailUrl: String? = null

        if (thumbnailQuality != ThumbnailQuality.NONE) {
            val imageUrlResizer = ImageUrlResizer()
            imageUrlResizer.getThumbnailUrl(path, ThumbnailQuality.LOW.sizeMultiplier)

            //If url had no width/height appended in given URL, then adding a staic value for thumbnail size.
            if (TextUtils.isEmpty(thumbnailUrl)) {
                thumbnailUrl = imageUrlResizer.getResizedImageUrl(path, UNKNOWN_THUMBNAIL_SIZE)
            }
        }

        //Showing placeholder and thumbnail in thumbnailIV.
        displayImage(thumbnailIV, thumbnailUrl, placeholderResID)

        subsamplingScaleImageView.setOnImageEventListener(object : SubsamplingScaleImageView.OnImageEventListener {
            override fun onImageLoaded() {
                progressView.visibility = View.GONE
                thumbnailIV.visibility = View.GONE
            }

            override fun onImageLoadError(e: Exception?) {
                progressView.visibility = View.GONE
                thumbnailIV.visibility = View.GONE
            }

            override fun onReady() {
            }

            override fun onTileLoadError(e: Exception?) {
            }

            override fun onPreviewReleased() {
            }

            override fun onPreviewLoadError(e: Exception?) {
            }
        })


        val requestOptions = getRequestOptions(0, false, circularImage = false, targetWidth = 0, targetHeight = 0, diskCacheStrategy = DEFAULT_DISK_CACHE_STRATEGY)

        val drawableRequestBuilder = Glide
                .with(subsamplingScaleImageView.context)
                .asBitmap()
                .load(path)
                .apply(requestOptions)

        drawableRequestBuilder
                .load(path)
                .into(object : CustomTarget<Bitmap>() {
                    override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                        subsamplingScaleImageView.setImage(ImageSource.cachedBitmap(resource).tilingDisabled())
                    }

                    override fun onLoadCleared(placeholder: Drawable?) {
                    }

                    override fun onLoadFailed(errorDrawable: Drawable?) {
                        //Note: Set errorDrawable on SubsamplingScaleImageView, if have started passing any error drawable.
                    }
                })
    }


    private fun getResourceToUri(context: Context, @AnyRes drawableId: Int): Uri {
        return Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + context.resources.getResourcePackageName(drawableId)
                + '/'.toString() + context.resources.getResourceTypeName(drawableId)
                + '/'.toString() + context.resources.getResourceEntryName(drawableId))
    }


    private fun getRequestOptions(placeholderResID: Int, centerCrop: Boolean, circularImage: Boolean = false, targetWidth: Int, targetHeight: Int,
                                  diskCacheStrategy: DiskCacheStrategy): RequestOptions {
        var requestOptions = RequestOptions()
                .diskCacheStrategy(diskCacheStrategy)

        if (placeholderResID != 0) {
            requestOptions = requestOptions.placeholder(placeholderResID)
        }

        if (centerCrop) {
            requestOptions = requestOptions.centerCrop()
        }

        if (circularImage) {
            requestOptions = requestOptions.circleCrop()
        }

        if (targetWidth != 0 && targetHeight != 0) {
            requestOptions = requestOptions.override(targetWidth, targetHeight)
        }

        return requestOptions
    }

    private fun getErrorBuilder(errorDrawableType: ErrorDrawableType, context: Context): RequestBuilder<Drawable>? {
        return when (errorDrawableType) {
            ErrorDrawableType.CENTER_CROP -> {
                Glide.with(context)
                        .load(R.drawable.ic_no_photo_with_message_gray)
                        .apply {
                            val errorOptions = RequestOptions()
                            apply(errorOptions)
                        }
            }
            ErrorDrawableType.CENTER_CROP_LONG -> {
                Glide.with(context)
                        .load(R.drawable.ic_no_photo_with_message_gray_long)
                        .apply {
                            val errorOptions = RequestOptions()
                                    .centerCrop()
                            apply(errorOptions)
                        }
            }
            else -> {
                null
            }
        }
    }

}
