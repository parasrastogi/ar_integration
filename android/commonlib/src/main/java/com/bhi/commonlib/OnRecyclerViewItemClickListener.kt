package com.bhi.commonlib

/**
 * Interface definition for a callback to be invoked when an item in RecyclerView gets clicked.
 */
interface OnRecyclerViewItemClickListener {
    fun onRecyclerViewItemClick(recyclerView: androidx.recyclerview.widget.RecyclerView?, position: Int)
}