package com.bhi.commonlib;

import java.lang.System;

/**
 * Interface definition for a callback to be invoked when an item in RecyclerView gets clicked.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/bhi/commonlib/OnRecyclerViewItemClickListener;", "", "onRecyclerViewItemClick", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "position", "", "commonlib_stage"})
public abstract interface OnRecyclerViewItemClickListener {
    
    public abstract void onRecyclerViewItemClick(@org.jetbrains.annotations.Nullable()
    androidx.recyclerview.widget.RecyclerView recyclerView, int position);
}