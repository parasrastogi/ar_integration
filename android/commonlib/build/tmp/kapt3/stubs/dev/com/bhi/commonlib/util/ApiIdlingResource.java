package com.bhi.commonlib.util;

import java.lang.System;

/**
 * An idling resource for API calls used in Espresso framework.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/bhi/commonlib/util/ApiIdlingResource;", "Landroidx/test/espresso/idling/net/UriIdlingResource;", "name", "", "timeout", "", "(Ljava/lang/String;J)V", "uriList", "", "getUriList", "()Ljava/util/List;", "beginLoad", "", "uri", "endLoad", "commonlib_dev"})
public final class ApiIdlingResource extends androidx.test.espresso.idling.net.UriIdlingResource {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> uriList = null;
    
    public ApiIdlingResource() {
        super(null, 0L);
    }
    
    public ApiIdlingResource(@org.jetbrains.annotations.NotNull()
    java.lang.String name, long timeout) {
        super(null, 0L);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getUriList() {
        return null;
    }
    
    @java.lang.Override()
    public void beginLoad(@org.jetbrains.annotations.Nullable()
    java.lang.String uri) {
    }
    
    @java.lang.Override()
    public void endLoad(@org.jetbrains.annotations.Nullable()
    java.lang.String uri) {
    }
}