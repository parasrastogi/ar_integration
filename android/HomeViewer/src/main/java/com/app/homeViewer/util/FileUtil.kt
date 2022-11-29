package com.app.homeViewer.util

import android.graphics.Bitmap
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

/**
 * A utility class for file operations.
 */
object FileUtil {

    fun saveFile(fileName: String, byteArray: ByteArray): Boolean {
        val file = File(fileName)

        if (!file.exists()) {
            file.createNewFile()
        }

        return try {
            val outputStream = FileOutputStream(file)
            outputStream.write(byteArray)
            outputStream.close()
            true
        } catch (ex: Exception) {
            ex.printStackTrace();
            false
        }
    }


    /**
     * Saves bitmap object in given imageFile path.
     */
    fun saveBitmap(bitmap: Bitmap, file: File): Boolean {
        var fileOutputStream: FileOutputStream? = null

        try {
            fileOutputStream = FileOutputStream(file.path)

            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)
            return true
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        } finally {
            try {
                fileOutputStream?.close()
            } catch (ex: IOException) {
                ex.printStackTrace()
            }

        }
    }
}