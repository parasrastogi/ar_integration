package com.app.homeViewer.fileDownload

import com.app.homeViewer.repository.TLSSocketFactory
import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.TimeUnit
import javax.net.ssl.HttpsURLConnection

class FileDownloaderCoroutines {

    interface Callback {
        fun onProgressUpdate(progress: Int)
        fun onDownloadSuccess()
        fun onDownloadFailure(exception: Exception)
        fun onDownloadCancel()
    }

    var isCancelled = false

    fun downloadFile(fileUrl: String, file: File, callback: Callback) {
        var input: InputStream? = null
        var output: OutputStream? = null
        var connection: HttpURLConnection? = null

        try {
            val url = URL(fileUrl)

            if (fileUrl.startsWith("https", true)) {
                connection = url.openConnection() as HttpsURLConnection
                connection.sslSocketFactory = TLSSocketFactory()
            } else {
                connection = url.openConnection() as HttpURLConnection
            }

            connection.doOutput = false
            connection.readTimeout = TimeUnit.MINUTES.toMillis(5).toInt()
            connection.connect()

            // expect HTTP 200 OK, so we don't mistakenly save error report
            // instead of the file
            if (connection.responseCode != HttpURLConnection.HTTP_OK) {
                callback.onDownloadFailure(Exception("Failure response code. Response code:${connection.responseCode}"))
            }

            // this will be useful to display download percentage
            // might be -1: server did not report the length
            val fileLength = connection.contentLength

            // download the file
            input = connection.inputStream
            output = FileOutputStream(file)

            val data = ByteArray(8192)
            var total = 0L

            while (true) {
                val readCount = input.read(data)

                if (readCount == -1) {
                    break
                }

                // allow canceling with back button
                if (isCancelled) {
                    input.close()
                    callback.onDownloadCancel()
                }

                total += readCount

                if (fileLength > 0) { //only if total length is known
                    callback.onProgressUpdate((total * 100 / fileLength).toInt())
                }

                output.write(data, 0, readCount)
            }
            callback.onDownloadSuccess()
        } catch (e: Exception) {
            e.printStackTrace()
            if (!isCancelled) {
                callback.onDownloadFailure(e)
            }
        } finally {
            try {
                output?.close()
                input?.close()
            } catch (ignored: IOException) {
            }

            connection?.disconnect()
        }
    }
}