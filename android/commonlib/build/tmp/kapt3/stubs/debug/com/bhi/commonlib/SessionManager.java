package com.bhi.commonlib;

import java.lang.System;

/**
 * @author Rahul Rastogi
 *
 * Provides some session related data operations.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0004J\u0016\u0010 \u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0019J\u0018\u0010\"\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010#\u001a\u0004\u0018\u00010\u0004J\u0016\u0010$\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u0015J\u0016\u0010&\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0019J\u0016\u0010\'\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u0019J\u0018\u0010)\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010*\u001a\u0004\u0018\u00010\u0004J\u0018\u0010+\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u0019H\u0007J\u0016\u0010-\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/bhi/commonlib/SessionManager;", "", "()V", "DEEP_LINKED_COMMUNITY_CODE", "", "DEEP_LINKED_SOURCE", "IS_AR_FURNITURE_HELPER_TEXT_SEEN", "IS_AR_MEASURE_HELPER_TEXT_SEEN", "IS_AR_POI_HELPER_TEXT_SEEN", "IS_GEOFENCE_NOTIFICATION_ENABLED", "LAST_LOGGED_IN_USER_EMAIL", "LOGGED_IN", "PREF_NAME", "PUSH_TOKEN", "USER", "clear", "", "context", "Landroid/content/Context;", "getDeepLinkedCommunityCode", "getDeepLinkedSource", "", "getLastLoggedInUserEmail", "getPushToken", "isARMeasureHelperTextSeen", "", "isFurnitureARHelperTextSeen", "isGeofenceNotificationEnabled", "isLoggedIn", "isPointOfInterestARHelperTextSeen", "savePushToken", "pushToken", "setARMeasureHelperTextSeen", "isSeen", "setDeepLinkedCommunityCode", "communityCode", "setDeepLinkedSource", "source", "setFurnitureARHelperTextSeen", "setGeofenceNotificationEnabled", "enabled", "setLastLoggedInUserEmail", "email", "setLoggedIn", "loggedIn", "setPointOfInterestARHelperTextSeen", "commonlib_debug"})
public final class SessionManager {
    @org.jetbrains.annotations.NotNull()
    public static final com.bhi.commonlib.SessionManager INSTANCE = null;
    private static final java.lang.String PREF_NAME = "session_pref";
    private static final java.lang.String USER = "user";
    private static final java.lang.String LOGGED_IN = "logged_in";
    private static final java.lang.String LAST_LOGGED_IN_USER_EMAIL = "last_logged_in_user_email";
    private static final java.lang.String DEEP_LINKED_COMMUNITY_CODE = "deep_linked_community_code";
    private static final java.lang.String DEEP_LINKED_SOURCE = "deep_linked_source";
    private static final java.lang.String IS_AR_FURNITURE_HELPER_TEXT_SEEN = "is_ar_furniture_helper_text_seen";
    private static final java.lang.String IS_AR_POI_HELPER_TEXT_SEEN = "is_ar_poi_helper_text_seen";
    private static final java.lang.String IS_AR_MEASURE_HELPER_TEXT_SEEN = "is_ar_measure_helper_text_seen";
    private static final java.lang.String PUSH_TOKEN = "push_token";
    private static final java.lang.String IS_GEOFENCE_NOTIFICATION_ENABLED = "is_geofence_notification_enabled";
    
    private SessionManager() {
        super();
    }
    
    public final boolean isLoggedIn(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    @android.annotation.SuppressLint(value = {"ApplySharedPref"})
    public final void setLoggedIn(@org.jetbrains.annotations.NotNull()
    android.content.Context context, boolean loggedIn) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLastLoggedInUserEmail(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    public final void setLastLoggedInUserEmail(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String email) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDeepLinkedCommunityCode(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    public final void setDeepLinkedCommunityCode(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String communityCode) {
    }
    
    public final int getDeepLinkedSource(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return 0;
    }
    
    public final void setDeepLinkedSource(@org.jetbrains.annotations.NotNull()
    android.content.Context context, int source) {
    }
    
    public final boolean isFurnitureARHelperTextSeen(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    public final void setFurnitureARHelperTextSeen(@org.jetbrains.annotations.NotNull()
    android.content.Context context, boolean isSeen) {
    }
    
    public final boolean isPointOfInterestARHelperTextSeen(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    public final void setPointOfInterestARHelperTextSeen(@org.jetbrains.annotations.NotNull()
    android.content.Context context, boolean isSeen) {
    }
    
    public final boolean isARMeasureHelperTextSeen(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    public final void setARMeasureHelperTextSeen(@org.jetbrains.annotations.NotNull()
    android.content.Context context, boolean isSeen) {
    }
    
    public final void clear(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final void savePushToken(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String pushToken) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPushToken(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    public final boolean isGeofenceNotificationEnabled(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    public final void setGeofenceNotificationEnabled(@org.jetbrains.annotations.NotNull()
    android.content.Context context, boolean enabled) {
    }
}