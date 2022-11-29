package com.bhi.commonlib.widgets;

import java.lang.System;

/**
 * Constants for defining placeholder view's state. Placeholder view content gets displayed as per
 * its state.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/bhi/commonlib/widgets/PlaceholderState;", "", "()V", "STATE_FAIL", "", "STATE_LOADING", "STATE_NO_DATA_FOUND", "STATE_SUCCESS", "commonlib_debug"})
public final class PlaceholderState {
    @org.jetbrains.annotations.NotNull()
    public static final com.bhi.commonlib.widgets.PlaceholderState INSTANCE = null;
    public static final int STATE_SUCCESS = 1;
    public static final int STATE_FAIL = 2;
    public static final int STATE_LOADING = 3;
    public static final int STATE_NO_DATA_FOUND = 4;
    
    private PlaceholderState() {
        super();
    }
}