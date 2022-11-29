package com.bhi.commonlib.widgets.customviewpager;

import java.lang.System;

/**
 * Created by ram on 7/10/16.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0013\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\rJ \u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\u0015\u0010\u0018\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00028\u0000H$\u00a2\u0006\u0002\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0015\u0010\u001c\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0014\u001a\u00020\b\u00a2\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u000e\u0010 \u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\bR\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/bhi/commonlib/widgets/customviewpager/BaseFragmentPagerAdapter;", "T", "Landroidx/fragment/app/FragmentPagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "(Landroidx/fragment/app/FragmentManager;)V", "mFragments", "", "", "Lcom/bhi/commonlib/util/BaseFragment;", "mItems", "", "addItem", "", "item", "(Ljava/lang/Object;)V", "clear", "destroyItem", "container", "Landroid/view/ViewGroup;", "position", "object", "", "getCount", "getFragment", "(Ljava/lang/Object;)Lcom/bhi/commonlib/util/BaseFragment;", "getFragmentAtPosition", "getItem", "getItemAtPosition", "(I)Ljava/lang/Object;", "getItemPosition", "instantiateItem", "removeItem", "commonlib_dev"})
public abstract class BaseFragmentPagerAdapter<T extends java.lang.Object> extends androidx.fragment.app.FragmentPagerAdapter {
    private final java.util.Map<java.lang.Integer, com.bhi.commonlib.util.BaseFragment> mFragments = null;
    private final java.util.List<T> mItems = null;
    
    public BaseFragmentPagerAdapter(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentManager fm) {
        super(null);
    }
    
    @java.lang.Override()
    public int getItemPosition(@org.jetbrains.annotations.NotNull()
    java.lang.Object object) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.bhi.commonlib.util.BaseFragment getItem(int position) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.Object instantiateItem(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup container, int position) {
        return null;
    }
    
    public final void addItem(T item) {
    }
    
    public final void removeItem(int position) {
    }
    
    public final void clear() {
    }
    
    @java.lang.Override()
    public int getCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void destroyItem(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup container, int position, @org.jetbrains.annotations.NotNull()
    java.lang.Object object) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected abstract com.bhi.commonlib.util.BaseFragment getFragment(T item);
    
    @org.jetbrains.annotations.Nullable()
    public com.bhi.commonlib.util.BaseFragment getFragmentAtPosition(int position) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final T getItemAtPosition(int position) {
        return null;
    }
}