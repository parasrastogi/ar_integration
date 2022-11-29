package com.app.homeViewer.util.zip

/**
 * Provides file/folder zip or un-zip features.
 */
interface Zipper {

    fun zipFile(sourceFile: String, destinationZipFile: String, password: String?): Exception?

    fun unZipFile(sourceZipFile: String, destinationFolder: String, password: String?): Exception?
}