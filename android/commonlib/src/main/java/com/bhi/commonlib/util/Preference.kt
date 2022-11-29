package com.bhi.commonlib.util

import android.content.Context
import android.content.SharedPreferences

object Preference {

    const val FIRST_TIME_PERMISSION = "first_time_permission"
    const val REMIND_ME_LATER_CLICKED = "remind_me_later_clicked"
    const val NEVER_CLICKED = "never_clicked"
    const val IS_DIALOG_ALREADY_SHOWED = "is_dialog_already_showed"
    const val LOGIN_SESSION_COUNT = "login_session_count"
    const val BIOMETRIC_ENABLED = "biometric_enabled"

    private fun getSharedPreferences(mContext: Context): SharedPreferences? {
        return mContext.getSharedPreferences("Preference", Context.MODE_PRIVATE)
    }

    fun setPreferences(mContext: Context, key: String, value: Boolean?) {
        getSharedPreferences(mContext)?.edit()?.putBoolean(key, value ?: false)?.apply()
    }

    fun getPreferences(mContext: Context, key: String, defaultValue: Boolean = false): Boolean {
        return getSharedPreferences(mContext)?.getBoolean(key, defaultValue) ?: defaultValue
    }

    fun setPreferences(mContext: Context, key: String, value: Int?) {
        getSharedPreferences(mContext)?.edit()?.putInt(key, value ?: 1)?.apply()
    }

    fun getPreferences(mContext: Context, key: String, defaultValue: Int = 1): Int {
        return getSharedPreferences(mContext)?.getInt(key, defaultValue) ?: defaultValue
    }

    fun clearPreference(mContext: Context) {
        getSharedPreferences(mContext)?.edit()?.clear()?.apply()
    }

}