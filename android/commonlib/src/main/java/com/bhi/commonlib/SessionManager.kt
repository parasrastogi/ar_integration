package com.bhi.commonlib

import android.annotation.SuppressLint
import android.content.Context

/**
 * @author Rahul Rastogi
 *
 * Provides some session related data operations.
 */
object SessionManager {

    private const val PREF_NAME = "session_pref"
    private const val USER = "user"
    private const val LOGGED_IN = "logged_in"
    private const val LAST_LOGGED_IN_USER_EMAIL = "last_logged_in_user_email"
    private const val DEEP_LINKED_COMMUNITY_CODE = "deep_linked_community_code"
    private const val DEEP_LINKED_SOURCE = "deep_linked_source"
    private const val IS_AR_FURNITURE_HELPER_TEXT_SEEN = "is_ar_furniture_helper_text_seen"
    private const val IS_AR_POI_HELPER_TEXT_SEEN = "is_ar_poi_helper_text_seen"
    private const val IS_AR_MEASURE_HELPER_TEXT_SEEN = "is_ar_measure_helper_text_seen"
    private const val PUSH_TOKEN = "push_token"
    private const val IS_GEOFENCE_NOTIFICATION_ENABLED = "is_geofence_notification_enabled"

    fun isLoggedIn(context: Context): Boolean {
        val sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return sp.getBoolean(LOGGED_IN, false)
    }

    @SuppressLint("ApplySharedPref")
    fun setLoggedIn(context: Context, loggedIn: Boolean) {
        val sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = sp.edit()

        editor.putBoolean(LOGGED_IN, loggedIn)
        editor.commit()
    }

    fun getLastLoggedInUserEmail(context: Context): String? {
        val sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return sp.getString(LAST_LOGGED_IN_USER_EMAIL, null)
    }


    fun setLastLoggedInUserEmail(context: Context, email: String?) {
        val sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = sp.edit()

        editor.putString(LAST_LOGGED_IN_USER_EMAIL, email)
        editor.apply()
    }


    fun getDeepLinkedCommunityCode(context: Context): String? {
        val sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return sp.getString(DEEP_LINKED_COMMUNITY_CODE, null)
    }


    fun setDeepLinkedCommunityCode(context: Context, communityCode: String?) {
        val sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = sp.edit()

        editor.putString(DEEP_LINKED_COMMUNITY_CODE, communityCode)
        editor.apply()
    }


    fun getDeepLinkedSource(context: Context): Int {
        val sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return sp.getInt(DEEP_LINKED_SOURCE, 0)
    }


    fun setDeepLinkedSource(context: Context, source: Int) {
        val sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = sp.edit()

        editor.putInt(DEEP_LINKED_SOURCE, source)
        editor.apply()
    }

    fun isFurnitureARHelperTextSeen(context: Context): Boolean {
        val sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return sp.getBoolean(IS_AR_FURNITURE_HELPER_TEXT_SEEN, false)
    }


    fun setFurnitureARHelperTextSeen(context: Context, isSeen: Boolean) {
        val sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = sp.edit()

        editor.putBoolean(IS_AR_FURNITURE_HELPER_TEXT_SEEN, isSeen)
        editor.apply()
    }


    fun isPointOfInterestARHelperTextSeen(context: Context): Boolean {
        val sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return sp.getBoolean(IS_AR_POI_HELPER_TEXT_SEEN, false)
    }


    fun setPointOfInterestARHelperTextSeen(context: Context, isSeen: Boolean) {
        val sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = sp.edit()

        editor.putBoolean(IS_AR_POI_HELPER_TEXT_SEEN, isSeen)
        editor.apply()
    }

    fun isARMeasureHelperTextSeen(context: Context): Boolean {
        val sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return sp.getBoolean(IS_AR_MEASURE_HELPER_TEXT_SEEN, false)
    }

    fun setARMeasureHelperTextSeen(context: Context, isSeen: Boolean) {
        val sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = sp.edit()

        editor.putBoolean(IS_AR_MEASURE_HELPER_TEXT_SEEN, isSeen)
        editor.apply()
    }


    fun clear(context: Context) {
        val lastLoggedInUserEmail = getLastLoggedInUserEmail(context)

        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
                .edit().run {
                    clear()
                    apply()
                }

        //Keeping it even after logout
        setLastLoggedInUserEmail(context, lastLoggedInUserEmail)
    }

    fun savePushToken(context: Context, pushToken: String) {
        val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        sharedPreferences
                .edit().apply {
                    putString(PUSH_TOKEN, pushToken)
                    apply()
                }
    }

    fun getPushToken(context: Context): String? {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
                .getString(PUSH_TOKEN, null)
    }

    fun isGeofenceNotificationEnabled(context: Context): Boolean {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
                .getBoolean(IS_GEOFENCE_NOTIFICATION_ENABLED, true)
    }

    fun setGeofenceNotificationEnabled(context: Context, enabled: Boolean) {
        val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        sharedPreferences
                .edit().apply {
                    putBoolean(IS_GEOFENCE_NOTIFICATION_ENABLED, enabled)
                    apply()
                }
    }

}
