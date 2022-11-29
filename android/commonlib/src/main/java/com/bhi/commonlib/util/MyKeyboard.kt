package com.bhi.commonlib.util

import android.app.Activity
import android.app.Service
import android.view.inputmethod.InputMethodManager
import android.widget.EditText


/**
 * @author Rahul Rastogi
 *
 * Provides soft keyboard handling methods.
 */
object MyKeyboard {

    fun showKeyboard(activity: Activity) {
        val view = activity.currentFocus

        if (null != view) {
            val imm = activity.getSystemService(Service.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }

    fun showKeyboard(activity: Activity, editText: EditText?) {

        if (null != editText) {
            editText.setSelection(editText.length())
            val imm = activity.getSystemService(Service.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
        }
    }

    fun hideKeyboard(activity: Activity) {
        val view = activity.currentFocus

        if (null != view && null != view.windowToken) {
            val inputManager = activity.getSystemService(Service.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_IMPLICIT_ONLY)
            inputManager.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }

}
