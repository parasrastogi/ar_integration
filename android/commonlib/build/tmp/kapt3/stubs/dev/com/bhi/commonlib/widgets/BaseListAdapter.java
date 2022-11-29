package com.bhi.commonlib.widgets;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0013\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0014J\u001f\u0010\u0015\u001a\u00020\u00122\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0017\"\u00028\u0000\u00a2\u0006\u0002\u0010\u0018J\u0016\u0010\u0015\u001a\u00020\u00122\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0019J\u001b\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u0012H\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0016J\u0017\u0010 \u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001b\u001a\u00020\u001cH\u0016\u00a2\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0013\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00028\u0000\u00a2\u0006\u0002\u0010&J\u0010\u0010\'\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u001cH\u0016J\u001d\u0010*\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u001dR*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006+"}, d2 = {"Lcom/bhi/commonlib/widgets/BaseListAdapter;", "T", "Landroid/widget/BaseAdapter;", "()V", "allItems", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getAllItems", "()Ljava/util/ArrayList;", "setAllItems", "(Ljava/util/ArrayList;)V", "onItemClickListener", "Lcom/bhi/commonlib/widgets/recyclerview/OnItemClickListener;", "getOnItemClickListener", "()Lcom/bhi/commonlib/widgets/recyclerview/OnItemClickListener;", "setOnItemClickListener", "(Lcom/bhi/commonlib/widgets/recyclerview/OnItemClickListener;)V", "add", "", "item", "(Ljava/lang/Object;)V", "addAll", "items", "", "([Ljava/lang/Object;)V", "", "addAt", "position", "", "(ILjava/lang/Object;)V", "clear", "getCount", "getItem", "(I)Ljava/lang/Object;", "getItemId", "", "remove", "", "(Ljava/lang/Object;)Z", "removeAt", "startIndex", "itemCount", "replaceAt", "commonlib_dev"})
public abstract class BaseListAdapter<T extends java.lang.Object> extends android.widget.BaseAdapter {
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<T> allItems;
    @org.jetbrains.annotations.Nullable()
    private com.bhi.commonlib.widgets.recyclerview.OnItemClickListener<T> onItemClickListener;
    
    public BaseListAdapter() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<T> getAllItems() {
        return null;
    }
    
    public final void setAllItems(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<T> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bhi.commonlib.widgets.recyclerview.OnItemClickListener<T> getOnItemClickListener() {
        return null;
    }
    
    public final void setOnItemClickListener(@org.jetbrains.annotations.Nullable()
    com.bhi.commonlib.widgets.recyclerview.OnItemClickListener<T> p0) {
    }
    
    public void clear() {
    }
    
    public final void addAll(@org.jetbrains.annotations.NotNull()
    T... items) {
    }
    
    public final void addAll(@org.jetbrains.annotations.Nullable()
    java.util.List<? extends T> items) {
    }
    
    public final void add(T item) {
    }
    
    public final void addAt(int position, T item) {
    }
    
    public final boolean remove(T item) {
        return false;
    }
    
    public void removeAt(int position) {
    }
    
    public void removeAt(int startIndex, int itemCount) {
    }
    
    public void replaceAt(int position, T item) {
    }
    
    @java.lang.Override()
    public int getCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public T getItem(int position) {
        return null;
    }
    
    @java.lang.Override()
    public long getItemId(int position) {
        return 0L;
    }
}