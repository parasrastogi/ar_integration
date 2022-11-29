package com.bhi.commonlib.app;

import java.lang.System;

/**
 * Holds constants for app-level configurations.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/bhi/commonlib/app/AppConfig;", "", "()V", "DEFAULT_USER_ACQUISITION_SOURCE", "", "GENERIC_PARTNER_NAME", "", "KEY_DEEP_LINK_COMMUNITY_CODE", "KEY_DEEP_LINK_SOURCE", "KEY_RECEIVING_ACCESS_TOKEN", "KEY_RECEIVING_REFRESH_TOKEN", "KEY_SENDING_ACCESS_TOKEN", "MAX_IMAGE_FILE_LENGTH", "MAX_IMAGE_RECT", "SHARED_IMAGE_MAX_RECT", "commonlib_debug"})
public final class AppConfig {
    @org.jetbrains.annotations.NotNull()
    public static final com.bhi.commonlib.app.AppConfig INSTANCE = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GENERIC_PARTNER_NAME = "New Home Navigator";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_RECEIVING_REFRESH_TOKEN = "refresh_token";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_RECEIVING_ACCESS_TOKEN = "access_token";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_SENDING_ACCESS_TOKEN = "Authorization";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_DEEP_LINK_COMMUNITY_CODE = "CommunityCode";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_DEEP_LINK_SOURCE = "source";
    public static final int MAX_IMAGE_FILE_LENGTH = 614400;
    public static final int MAX_IMAGE_RECT = 1024;
    public static final int SHARED_IMAGE_MAX_RECT = 1024;
    public static final int DEFAULT_USER_ACQUISITION_SOURCE = 4;
    
    private AppConfig() {
        super();
    }
}