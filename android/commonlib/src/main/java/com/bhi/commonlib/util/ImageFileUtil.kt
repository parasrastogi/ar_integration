package com.bhi.commonlib.util

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.os.Build
import android.provider.MediaStore
import androidx.exifinterface.media.ExifInterface
import com.bhi.commonlib.R
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

/**
 * Provides helper methods for image manipulations.
 */
object ImageFileUtil {

    fun scaleDownAndCompress(imageFile: File, reqWidth: Int, reqHeight: Int, maxFileLengthInBytes: Int): Boolean {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true

        BitmapFactory.decodeFile(imageFile.path, options)
        val reqSampleSize = calculateInSampleSize(options, reqWidth, reqHeight)

        //If imageUrl has of bigger size than reqWidth/reqHeight then, scaling down imageUrl.
        if (reqSampleSize > 1) {
            options.inJustDecodeBounds = false
            options.inSampleSize = reqSampleSize

            //Fetching scaled down imageUrl.
            val bitmap = BitmapFactory.decodeFile(imageFile.path, options)
            var fileOutputStream: FileOutputStream? = null

            try {
                fileOutputStream = FileOutputStream(imageFile.path)
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)
                bitmap.recycle()
            } catch (e: Exception) {
                e.printStackTrace()
                return false
            } finally {
                try {
                    fileOutputStream?.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }

        //If file size on physical memory is more than maxFileLength then, compressing imageUrl.
        if (imageFile.length() > maxFileLengthInBytes) {
            val compressPercent = (maxFileLengthInBytes * 100 / imageFile.length()).toInt()
            var fileOutputStream: FileOutputStream? = null

            return try {
                val bitmap = BitmapFactory.decodeFile(imageFile.path)
                fileOutputStream = FileOutputStream(imageFile.path)
                bitmap.compress(Bitmap.CompressFormat.JPEG, compressPercent, fileOutputStream)
                true
            } catch (e: Exception) {
                e.printStackTrace()
                false
            } finally {
                try {
                    fileOutputStream?.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        } else {
            return true
        }
    }


    private fun calculateInSampleSize(options: BitmapFactory.Options, reqWidth: Int, reqHeight: Int): Int {
        val height = options.outHeight
        val width = options.outWidth
        var inSampleSize = 1

        if (height > reqHeight || width > reqWidth) {
            val halfHeight = height / 2
            val halfWidth = width / 2

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while (halfHeight / inSampleSize >= reqHeight && halfWidth / inSampleSize >= reqWidth) {
                inSampleSize *= 2
            }
        }

        return inSampleSize
    }

    fun getImageOrientation(currentImagePath: String): Int {
        val exifInterface = ExifInterface(currentImagePath)

        return when (exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_UNDEFINED)) {
            ExifInterface.ORIENTATION_ROTATE_90 ->
                90
            ExifInterface.ORIENTATION_ROTATE_180 ->
                180
            ExifInterface.ORIENTATION_ROTATE_270 ->
                270
            ExifInterface.ORIENTATION_NORMAL ->
                0
            else ->
                -1
        }
    }

    fun rotateImage(source: Bitmap, angle: Float): Bitmap {
        val matrix = Matrix()
        matrix.postRotate(angle)
        return Bitmap.createBitmap(source, 0, 0, source.width, source.height, matrix, true)
    }

    /**
     * Saves bitmap object in given imageFile path.
     */
    fun saveBitmap(imageFile: File, bitmap: Bitmap): Boolean {
        val fileOutputStream = FileOutputStream(imageFile.path)

        return try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        } finally {
            try {
                fileOutputStream.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    fun savePublicImage(context: Context, bitmap: Bitmap, fileName: String): String? {
        val values = ContentValues()
        values.put(MediaStore.Images.Media.TITLE, context.getString(R.string.app_name))
        values.put(MediaStore.Images.Media.DISPLAY_NAME, fileName)
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/*")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            values.put(
                    MediaStore.Images.Media.RELATIVE_PATH,
                    "Pictures/${context.getString(R.string.app_name)}"
            )
        }
        val item =
                context.contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
        item?.let { uri ->
            context.contentResolver.openFileDescriptor(uri, "w", null).use { pfd ->
                pfd?.let {
                    val output = FileOutputStream(it.fileDescriptor)
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, output)
                    output.close()
                    return uri.path
                } ?: return null
            }
        } ?: return null
    }
}
