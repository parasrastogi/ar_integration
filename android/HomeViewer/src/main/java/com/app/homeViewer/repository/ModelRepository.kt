package com.app.homeViewer.repository

import android.os.Handler
import com.app.homeViewer.fileDownload.FileDownloader
import java.io.File
import java.lang.ref.WeakReference

class ModelRepository private constructor() {

    companion object {
        private var instance: ModelRepository? = null

        fun getInstance(): ModelRepository {
            return instance
                    ?: ModelRepository().apply { instance = this }
        }
    }

    /**
     * Downloading model from network.
     */
    fun download3DModel(responseHandler: WeakReference<Handler>, fileUrl: String, file: File, callback: WeakReference<FileDownloader.Callback>)
            : FileDownloader {
        val fileDownloader = FileDownloader(responseHandler)
        fileDownloader.downloadFile(fileUrl, file, callback.get()!!)
        return fileDownloader
    }

}