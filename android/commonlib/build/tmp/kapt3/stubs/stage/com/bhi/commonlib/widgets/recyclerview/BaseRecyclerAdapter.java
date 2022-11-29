package com.bhi.commonlib.widgets.recyclerview;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0013\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\u00162\u0012\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u001b\"\u00028\u0000\u00a2\u0006\u0002\u0010\u001cJ\u0016\u0010\u0019\u001a\u00020\u00162\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001dJ\u001b\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0017\u001a\u00028\u0000\u00a2\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\u0016H\u0016J\u0017\u0010#\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001f\u001a\u00020 H\u0016\u00a2\u0006\u0002\u0010$J\b\u0010%\u001a\u00020 H\u0016J\u0010\u0010&\u001a\u00020\'2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0006\u0010(\u001a\u00020\u0016J\u000e\u0010)\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u0014H\u0016J\u0013\u0010,\u001a\u00020\'2\u0006\u0010\u0017\u001a\u00028\u0000\u00a2\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010.\u001a\u00020\u00162\u0006\u0010/\u001a\u00020 2\u0006\u00100\u001a\u00020 H\u0016J\u001d\u00101\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0017\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010!R*\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0007j\b\u0012\u0004\u0012\u00028\u0000`\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00062"}, d2 = {"Lcom/bhi/commonlib/widgets/recyclerview/BaseRecyclerAdapter;", "T", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "()V", "allItems", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getAllItems", "()Ljava/util/ArrayList;", "setAllItems", "(Ljava/util/ArrayList;)V", "onItemClickListener", "Lcom/bhi/commonlib/widgets/recyclerview/OnItemClickListener;", "getOnItemClickListener", "()Lcom/bhi/commonlib/widgets/recyclerview/OnItemClickListener;", "setOnItemClickListener", "(Lcom/bhi/commonlib/widgets/recyclerview/OnItemClickListener;)V", "parentRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "add", "", "item", "(Ljava/lang/Object;)V", "addAll", "items", "", "([Ljava/lang/Object;)V", "", "addAt", "position", "", "(ILjava/lang/Object;)V", "clear", "getItem", "(I)Ljava/lang/Object;", "getItemCount", "isLastItem", "", "notifyDataSetChangedWithCrashHandling", "notifyItemChangedWithCrashHandling", "onAttachedToRecyclerView", "recyclerView", "remove", "(Ljava/lang/Object;)Z", "removeAt", "startIndex", "itemCount", "replaceAt", "commonlib_stage"})
public abstract class BaseRecyclerAdapter<T extends java.lang.Object, VH extends androidx.recyclerview.widget.RecyclerView.ViewHolder> extends androidx.recyclerview.widget.RecyclerView.Adapter<VH> {
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<T> allItems;
    @org.jetbrains.annotations.Nullable()
    private com.bhi.commonlib.widgets.recyclerview.OnItemClickListener<T> onItemClickListener;
    private androidx.recyclerview.widget.RecyclerView parentRecyclerView;
    
    public BaseRecyclerAdapter() {
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
    
    public boolean isLastItem(int position) {
        return false;
    }
    
    public void removeAt(int position) {
    }
    
    public void removeAt(int startIndex, int itemCount) {
    }
    
    public void replaceAt(int position, T item) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public T getItem(int position) {
        return null;
    }
    
    @java.lang.Override()
    public void onAttachedToRecyclerView(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView recyclerView) {
    }
    
    public final void notifyItemChangedWithCrashHandling(int position) {
    }
    
    public final void notifyDataSetChangedWithCrashHandling() {
    }
}