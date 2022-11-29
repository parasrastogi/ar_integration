package com.app.homeViewer.fileDownload

import android.app.AlertDialog
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.widget.ProgressBar
import com.app.homeViewer.R
import kotlinx.android.synthetic.main.download_dialog_layout.view.*

class DownloadDialog private constructor(private val builder: Builder) {

    class Builder(private val context: Context) {
        private var message: String? = null
        private var progress = 0
        private var progressBar: ProgressBar? = null
        private var dialog: AlertDialog? = null
        private var progressTint = Color.BLACK
        private lateinit var onCancelClick: () -> Unit

        fun setMessage(message: String): Builder {
            this.message = message
            return this
        }

        fun setMessage(messageResId: Int): Builder {
            this.message = context.getString(messageResId)
            return this
        }

        fun setOnCancelClickListener(onCancelClick: () -> Unit): Builder {
            this.onCancelClick = onCancelClick
            return this
        }

        fun setProgressTint(progressTint: Int): Builder {
            this.progressTint = progressTint
            return this
        }

        fun build(): DownloadDialog {
            val view = LayoutInflater.from(context).inflate(R.layout.download_dialog_layout, null)
            progressBar = view.findViewById(R.id.pb_download_progress)

            progressBar!!.progressTintList = ColorStateList.valueOf(progressTint)
            view.txv_message.text = message

            view.txv_cancel.setOnClickListener {
                dismiss()

                if (this::onCancelClick.isInitialized) {
                    onCancelClick()
                }
            }

            dialog = AlertDialog.Builder(context)
                    .setView(view)
                    .setCancelable(false)
                    .create()

            dialog!!.setCanceledOnTouchOutside(false)
            return DownloadDialog(this)
        }

        fun show() {
            build()
            dialog!!.show()
        }

        fun dismiss() {
            dialog?.dismiss()
        }

        fun setProgress(progress: Int) {
            this.progress = progress
            progressBar?.progress = progress
        }
    }

    fun show() {
        builder.show()
    }

    fun updateProgress(progress: Int) {
        builder.setProgress(progress)
    }

    fun dismiss() {
        builder.dismiss()
    }

}