package com.bhi.commonlib.util

import android.net.Uri
import android.text.TextUtils

/**
 * Provides image url for resized url. This is helpful in loading image faster if we load only required size of image, not extra.
 */
class ImageUrlResizer {

    companion object {
        const val MAX_HEIGHT = "maxheight"
        const val MAX_WIDTH = "maxwidth"
        const val MAX_IMAGE_SIZE_ALLOWED = 1440
    }

    fun getResizedImageUrl(imageUrl: String?, maxSize: Int): String? {
        if (TextUtils.isEmpty(imageUrl) || maxSize <= 0) {
            return imageUrl
        }

        if (imageUrl?.endsWith("1x1.gif") == true) {
            return null
        }

        //Note: This check is added to avoid loading images in very big sizes so that, out of memory exceptions doesn't occur.
        //Library like: Glide even causes out of memory exceptions when big resolution images are loaded.
        val maxResolution = if (maxSize > MAX_IMAGE_SIZE_ALLOWED) {
            MAX_IMAGE_SIZE_ALLOWED
        } else {
            maxSize
        }

        return "$imageUrl?$MAX_WIDTH=$maxResolution&$MAX_HEIGHT=$maxResolution"
    }

    fun getThumbnailUrl(imageUrl: String?, sizeMultiplier: Float): String? {
        val uri = Uri.parse(imageUrl)
        val maxSizeString = uri.getQueryParameter(MAX_WIDTH)
        val maxSize: Int

        //If there is no max width parameter in image url, then preparing Thumbnail url isn't possible.
        if (maxSizeString == null || TextUtils.isEmpty(maxSizeString) || maxSizeString.toInt() == 0) {
            return null
        }

        maxSize = (maxSizeString.toInt() * sizeMultiplier).toInt()

        val actualUrl = uri.scheme + "://" + (uri.host ?: "") + uri.path
        return getResizedImageUrl(actualUrl, maxSize)
    }

}