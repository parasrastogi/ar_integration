package com.bhi.commonlib.widgets.recyclerview;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/bhi/commonlib/widgets/recyclerview/OnItemClickListener;", "T", "", "onItemClick", "", "item", "position", "", "(Ljava/lang/Object;I)V", "commonlib_dev"})
public abstract interface OnItemClickListener<T extends java.lang.Object> {
    
    public abstract void onItemClick(T item, int position);
}