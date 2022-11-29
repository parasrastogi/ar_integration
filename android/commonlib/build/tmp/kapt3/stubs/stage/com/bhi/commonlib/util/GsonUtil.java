package com.bhi.commonlib.util;

import java.lang.System;

/**
 * @author Rahul Rastogi.
 *
 * Provides Json serialization and de-serialization methods.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ#\u0010\n\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u000b\u001a\u0002H\u00042\b\b\u0002\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ#\u0010\u000f\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u000b\u001a\u0002H\u00042\b\b\u0002\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/bhi/commonlib/util/GsonUtil;", "", "()V", "fromJson", "T", "json", "", "type", "Ljava/lang/reflect/Type;", "(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "toJson", "data", "serializeNulls", "", "(Ljava/lang/Object;Z)Ljava/lang/String;", "toJsonObject", "Lcom/google/gson/JsonObject;", "(Ljava/lang/Object;Z)Lcom/google/gson/JsonObject;", "commonlib_stage"})
public final class GsonUtil {
    @org.jetbrains.annotations.NotNull()
    public static final com.bhi.commonlib.util.GsonUtil INSTANCE = null;
    
    private GsonUtil() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final <T extends java.lang.Object>T fromJson(@org.jetbrains.annotations.Nullable()
    java.lang.String json, @org.jetbrains.annotations.NotNull()
    java.lang.reflect.Type type) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>java.lang.String toJson(T data, boolean serializeNulls) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>com.google.gson.JsonObject toJsonObject(T data, boolean serializeNulls) {
        return null;
    }
}