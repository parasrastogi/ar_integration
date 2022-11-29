package com.bhi.commonlib.util

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.PorterDuff
import android.text.TextUtils
import android.view.Window
import android.widget.ProgressBar
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.bhi.commonlib.R


/**
 * @author Rahul Rastogi
 *
 *
 * A class for easing out some common dialog related operations.
 */
class DialogManager private constructor() {

    companion object {
        val instance: DialogManager = DialogManager()
    }

    var tintColor = 0
        set(value) {
            field = if (value != 0) {
                value
            } else {
                Color.BLACK
            }
        }

    fun getProgressDialog(context: Context): Dialog {
        val progressBar = ProgressBar(context)
        progressBar.indeterminateDrawable?.setColorFilter(tintColor, PorterDuff.Mode.MULTIPLY)

        val progressDialog = Dialog(context)
        progressDialog.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        progressDialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
        progressDialog.setContentView(progressBar)

        progressDialog.setCancelable(false)
        progressDialog.setCanceledOnTouchOutside(false)
        return progressDialog
    }

    fun getDialogWithoutProgress(context: Context): Dialog {
        val progressDialog = Dialog(context)
        progressDialog.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        progressDialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)

        progressDialog.setCancelable(false)
        progressDialog.setCanceledOnTouchOutside(false)
        return progressDialog
    }

    fun getOkDialog(context: Context, @StringRes resourceId: Int): Dialog {
        return getOkDialog(context, null, context.getString(resourceId), canceledOnTouchOutside = true, cancelable = true)
    }

    fun getOkDialog(context: Context, message: String?): Dialog {
        return getOkDialog(context, null, message, canceledOnTouchOutside = true, cancelable = true)
    }

    fun getOkDialog(context: Context, message: String?, onOkClickListener: DialogInterface.OnClickListener?, onCancelClickListener: DialogInterface.OnClickListener? = null): Dialog {
        return getOkDialog(context, null, message, canceledOnTouchOutside = true, cancelable = true, onOkClickListener = onOkClickListener, onCancelClickListener = onCancelClickListener)
    }

    fun getOkDialog(context: Context, @StringRes messageResId: Int, onOkClickListener: DialogInterface.OnClickListener?): Dialog {
        return getOkDialog(context, null, context.getString(messageResId), canceledOnTouchOutside = true, cancelable = true, onOkClickListener = onOkClickListener)
    }

    fun getOkDialog(context: Context, title: String, message: String?): Dialog {
        return getOkDialog(context, title, message, canceledOnTouchOutside = true, cancelable = true)
    }


    fun getOkDialog(context: Context, title: String?, message: String?, canceledOnTouchOutside: Boolean = true,
                    cancelable: Boolean = true, onOkClickListener: DialogInterface.OnClickListener? = null,
                    onCancelClickListener: DialogInterface.OnClickListener? = null, onCancelListener: DialogInterface.OnCancelListener? = null,
                    @StringRes positiveResId: Int = android.R.string.ok,
                    @StringRes negativeResId: Int = android.R.string.cancel): AlertDialog {

        val alertDialogBuilder = AlertDialog.Builder(context)
        alertDialogBuilder.setCancelable(cancelable)

        if (onCancelListener != null) {
            alertDialogBuilder.setOnCancelListener(onCancelListener)
        }

        alertDialogBuilder.setPositiveButton(positiveResId, onOkClickListener)

        if (onCancelClickListener != null) {
            alertDialogBuilder.setNegativeButton(negativeResId, onCancelClickListener)
        }

        val dialog = alertDialogBuilder.create()

        if (!TextUtils.isEmpty(title)) {
            dialog.setTitle(title)
        }

        if (!TextUtils.isEmpty(message)) {
            dialog.setMessage(message)
        }

        dialog.setCanceledOnTouchOutside(canceledOnTouchOutside)

        dialog.setOnShowListener {
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(tintColor)

            if (onCancelClickListener != null) {
                dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(ContextCompat.getColor(context, R.color.black))
            }
        }

        return dialog
    }
}