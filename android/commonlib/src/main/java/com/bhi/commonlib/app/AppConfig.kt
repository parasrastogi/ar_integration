package com.bhi.commonlib.app

/**
 * Holds constants for app-level configurations.
 */
object AppConfig {

    const val GENERIC_PARTNER_NAME = "New Home Navigator"

    //API auth token keys
    const val KEY_RECEIVING_REFRESH_TOKEN = "refresh_token"
    const val KEY_RECEIVING_ACCESS_TOKEN = "access_token"
    const val KEY_SENDING_ACCESS_TOKEN = "Authorization"

    //Deep link keys
    const val KEY_DEEP_LINK_COMMUNITY_CODE = "CommunityCode"
    const val KEY_DEEP_LINK_SOURCE = "source"

    const val MAX_IMAGE_FILE_LENGTH = 600 * 1024//600 KB
    const val MAX_IMAGE_RECT = 1024 //1024 pixels
    const val SHARED_IMAGE_MAX_RECT = 1024
    const val DEFAULT_USER_ACQUISITION_SOURCE = 4
}