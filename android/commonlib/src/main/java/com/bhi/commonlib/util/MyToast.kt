package com.bhi.commonlib.util

import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast

/**
 * @author Rahul Rastogi
 *
 * A utility class helps in displaying custom Toast messages.
 */
object MyToast {

    @JvmOverloads
    fun makeText(context: Context, stringResourceId: Int, duration: Int = Toast.LENGTH_SHORT) {
        makeText(context, context.getString(stringResourceId), duration, Gravity.CENTER)
    }

    @JvmOverloads
    fun makeText(context: Context, text: String, duration: Int = Toast.LENGTH_SHORT, gravity: Int = Gravity.CENTER) {
        val toast = Toast.makeText(context, text, duration)
        toast.setGravity(gravity, 0, 0)

        val textView = toast.view?.findViewById<TextView>(android.R.id.message)
        textView?.gravity = Gravity.CENTER

        toast.show()
    }

    fun makeTextAbove(view: View, text: String) {
        val left = view.left - view.width / 2
        val toast = Toast.makeText(view.context, text, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.CENTER_HORIZONTAL, left, view.top)
        toast.show()
    }
}
