package com.bhi.commonlib;

import java.lang.System;

/**
 * Holds user details.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u001e\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\f\u00a8\u0006\u001f"}, d2 = {"Lcom/bhi/commonlib/User;", "Ljava/io/Serializable;", "()V", "bdxPartnerId", "", "getBdxPartnerId", "()I", "setBdxPartnerId", "(I)V", "email", "", "getEmail", "()Ljava/lang/String;", "setEmail", "(Ljava/lang/String;)V", "id", "getId", "setId", "isGuestUser", "", "()Z", "setGuestUser", "(Z)V", "partnerId", "getPartnerId", "setPartnerId", "prospectId", "getProspectId", "setProspectId", "uupUserId", "getUupUserId", "commonlib_stage"})
public final class User implements java.io.Serializable {
    @com.google.gson.annotations.SerializedName(value = "BDXID")
    private int bdxPartnerId = 0;
    @com.google.gson.annotations.SerializedName(value = "PartnerID")
    private int partnerId = 0;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "UUPUserID")
    private final java.lang.String uupUserId = null;
    @com.google.gson.annotations.SerializedName(value = "ID")
    private int id = 0;
    @com.google.gson.annotations.SerializedName(value = "ProspectID")
    private int prospectId = 0;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "Email")
    private java.lang.String email;
    private boolean isGuestUser = false;
    
    public User() {
        super();
    }
    
    public final int getBdxPartnerId() {
        return 0;
    }
    
    public final void setBdxPartnerId(int p0) {
    }
    
    public final int getPartnerId() {
        return 0;
    }
    
    public final void setPartnerId(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUupUserId() {
        return null;
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    public final int getProspectId() {
        return 0;
    }
    
    public final void setProspectId(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getEmail() {
        return null;
    }
    
    public final void setEmail(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final boolean isGuestUser() {
        return false;
    }
    
    public final void setGuestUser(boolean p0) {
    }
}