package com.bhi.commonlib.widgets.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapterWithViewBinding<T, V : ViewDataBinding> : BaseRecyclerAdapter<T, BaseRecyclerAdapterWithViewBinding.BaseRecyclerViewHolder<V>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRecyclerViewHolder<V> {
        return BaseRecyclerViewHolder(
            getViewBinding(
                LayoutInflater.from(parent.context),
                parent,
                viewType
            )
        )
    }

    abstract fun getViewBinding(layoutInflater: LayoutInflater, parent: ViewGroup, viewType: Int): V

    class BaseRecyclerViewHolder<V : ViewDataBinding>(val viewBinding: V) :
        RecyclerView.ViewHolder(viewBinding.root)
}