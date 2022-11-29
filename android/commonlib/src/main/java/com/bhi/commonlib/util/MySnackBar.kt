package com.bhi.commonlib.util

import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar


/**
 * @author Rahul Rastogi
 *
 * This is a utility class to use Snackbar UI component with ease from multiple screens.
 */
object MySnackBar {

    fun make(view: View, @StringRes messageResId: Int) {
        make(view, messageResId, Snackbar.LENGTH_LONG)
    }

    fun make(view: View, message: CharSequence) {
        make(view, message, Snackbar.LENGTH_LONG)
    }

    fun make(view: View, @StringRes messageResId: Int, duration: Int) {
        make(view, view.resources.getString(messageResId), duration)
    }

    fun make(view: View, message: CharSequence, duration: Int) {
        val snackBar = Snackbar.make(view, message, duration)
        //val textView = snackBar.view.findViewById<TextView>(androidx...R.id.snackbar_text)
        // textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, view.resources.getDimension(R.dimen.text_size_snackbar))
        snackBar.show()
    }


    fun make(view: View, message: String, actionTitle: String, actionTintColor: Int? = null, onActionClick: (() -> Unit)? = null,
             cancelable: Boolean = false, duration: Int = Snackbar.LENGTH_INDEFINITE) {

        val snackbar = Snackbar.make(view, message, duration)
                .apply {
                    setAction(actionTitle) {
                        onActionClick?.invoke()
                    }
                }

        actionTintColor?.let { snackbar.setActionTextColor(actionTintColor) }

        val messageTV = snackbar.view.findViewById(com.google.android.material.R.id.snackbar_text) as TextView?
        messageTV?.maxLines = 10

        if (cancelable) {
            snackbar.view.setOnClickListener {
                if (it !is EditText) {
                    snackbar.dismiss()
                }
            }
        }
        snackbar.show()
    }

}