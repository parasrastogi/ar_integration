package com.bhi.commonlib.repository;

import java.lang.System;

/**
 * Holds error details while repository operations fail due to any reason.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0005H\u00d6\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\t\u00a8\u0006\u0018"}, d2 = {"Lcom/bhi/commonlib/repository/RepositoryError;", "", "errorType", "Lcom/bhi/commonlib/repository/ErrorType;", "message", "", "(Lcom/bhi/commonlib/repository/ErrorType;Ljava/lang/String;)V", "errorCode", "getErrorCode", "()Ljava/lang/String;", "setErrorCode", "(Ljava/lang/String;)V", "getErrorType", "()Lcom/bhi/commonlib/repository/ErrorType;", "getMessage", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "commonlib_dev"})
public final class RepositoryError {
    @org.jetbrains.annotations.NotNull()
    private final com.bhi.commonlib.repository.ErrorType errorType = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String message = null;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String errorCode;
    
    /**
     * Holds error details while repository operations fail due to any reason.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.repository.RepositoryError copy(@org.jetbrains.annotations.NotNull()
    com.bhi.commonlib.repository.ErrorType errorType, @org.jetbrains.annotations.Nullable()
    java.lang.String message) {
        return null;
    }
    
    /**
     * Holds error details while repository operations fail due to any reason.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Holds error details while repository operations fail due to any reason.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Holds error details while repository operations fail due to any reason.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public RepositoryError() {
        super();
    }
    
    public RepositoryError(@org.jetbrains.annotations.NotNull()
    com.bhi.commonlib.repository.ErrorType errorType, @org.jetbrains.annotations.Nullable()
    java.lang.String message) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.repository.ErrorType component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bhi.commonlib.repository.ErrorType getErrorType() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getErrorCode() {
        return null;
    }
    
    public final void setErrorCode(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
}