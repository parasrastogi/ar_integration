package com.app.homeViewer.util.zip

import android.text.TextUtils
import net.lingala.zip4j.core.ZipFile
import net.lingala.zip4j.model.ZipParameters
import java.io.File


/**
 * An implementation of Zipper using Mzip-Android library.
 */
class MZipper : Zipper {

    override fun zipFile(sourceFile: String, destinationZipFile: String, password: String?)
            : Exception? {

        return try {
            val parameters = ZipParameters()
            parameters.compressionMethod = 8
            parameters.compressionLevel = 5

            if (!TextUtils.isEmpty(password)) {
                parameters.isEncryptFiles = true
                parameters.encryptionMethod = 99
                parameters.aesKeyStrength = 3
                parameters.setPassword(password)
            }

            val targetFile = File(sourceFile)
            val zipFile = ZipFile(destinationZipFile)

            if (targetFile.isFile) {
                zipFile.addFile(targetFile, parameters)
            } else if (targetFile.isDirectory) {
                zipFile.addFolder(targetFile, parameters)
            }

            null
        } catch (ex: Exception) {
            ex.printStackTrace()
            ex
        }
    }

    override fun unZipFile(sourceZipFile: String, destinationFolder: String, password: String?)
            : Exception? {

        return try {
            val zipFile = ZipFile(sourceZipFile)

            if (zipFile.isEncrypted) {
                zipFile.setPassword(password)
            }
            zipFile.extractAll(destinationFolder)
            null
        } catch (ex: Exception) {
            ex.printStackTrace()
            ex
        }
    }

}