package com.bhi.commonlib.widgets.recyclerview;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004:\u0001\u0010B\u0005\u00a2\u0006\u0002\u0010\u0006J%\u0010\u0007\u001a\u00028\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&\u00a2\u0006\u0002\u0010\u000eJ\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/bhi/commonlib/widgets/recyclerview/BaseRecyclerAdapterWithViewBinding;", "T", "V", "Landroidx/databinding/ViewDataBinding;", "Lcom/bhi/commonlib/widgets/recyclerview/BaseRecyclerAdapter;", "Lcom/bhi/commonlib/widgets/recyclerview/BaseRecyclerAdapterWithViewBinding$BaseRecyclerViewHolder;", "()V", "getViewBinding", "layoutInflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;I)Landroidx/databinding/ViewDataBinding;", "onCreateViewHolder", "BaseRecyclerViewHolder", "commonlib_stage"})
public abstract class BaseRecyclerAdapterWithViewBinding<T extends java.lang.Object, V extends androidx.databinding.ViewDataBinding> extends com.bhi.commonlib.widgets.recyclerview.BaseRecyclerAdapter<T, com.bhi.commonlib.widgets.recyclerview.BaseRecyclerAdapterWithViewBinding.BaseRecyclerViewHolder<V>> {
    
    public BaseRecyclerAdapterWithViewBinding() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.bhi.commonlib.widgets.recyclerview.BaseRecyclerAdapterWithViewBinding.BaseRecyclerViewHolder<V> onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract V getViewBinding(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater layoutInflater, @org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType);
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0002\u00a2\u0006\u0002\u0010\u0005R\u0013\u0010\u0004\u001a\u00028\u0002\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/bhi/commonlib/widgets/recyclerview/BaseRecyclerAdapterWithViewBinding$BaseRecyclerViewHolder;", "V", "Landroidx/databinding/ViewDataBinding;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewBinding", "(Landroidx/databinding/ViewDataBinding;)V", "getViewBinding", "()Landroidx/databinding/ViewDataBinding;", "Landroidx/databinding/ViewDataBinding;", "commonlib_stage"})
    public static final class BaseRecyclerViewHolder<V extends androidx.databinding.ViewDataBinding> extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final V viewBinding = null;
        
        public BaseRecyclerViewHolder(@org.jetbrains.annotations.NotNull()
        V viewBinding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final V getViewBinding() {
            return null;
        }
    }
}