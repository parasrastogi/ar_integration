package com.bhi.commonlib.widgets.recyclerview

interface OnItemClickListener<T> {
    fun onItemClick(item: T, position: Int)
}