package com.bhi.commonlib.widgets.recyclerview

import androidx.recyclerview.widget.RecyclerView
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

abstract class BaseRecyclerAdapter<T, VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {

    var allItems: ArrayList<T> = ArrayList()
    var onItemClickListener: OnItemClickListener<T>? = null
    private var parentRecyclerView: RecyclerView? = null

    open fun clear() {
        allItems.clear()
    }

    fun addAll(vararg items: T) {
        Collections.addAll(allItems, *items)
    }

    fun addAll(items: List<T>?) {
        if (items != null)
            allItems.addAll(items)
    }

    fun add(item: T) {
        allItems.add(item)
    }

    fun addAt(position: Int, item: T) {
        allItems.add(position, item)
    }

    fun remove(item: T): Boolean {
        return allItems.remove(item)
    }

    open fun isLastItem(position: Int): Boolean {
        return position == allItems.size - 1
    }

    open fun removeAt(position: Int) {
        if (allItems.isNotEmpty() && position >= 0 && position < allItems.size)
            allItems.removeAt(position)
    }

    open fun removeAt(startIndex: Int, itemCount: Int) {
        for (index in 0 until itemCount) {
            val position = index + startIndex
            removeAt(position)
        }
    }

    open fun replaceAt(position: Int, item: T) {
        if (allItems.isNotEmpty() && position >= 0 && position < allItems.size)
            allItems.removeAt(position)
        allItems.add(position, item)
    }

    override fun getItemCount(): Int {
        return allItems.size
    }

    open fun getItem(position: Int): T? {
        return allItems.getOrNull(position)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        parentRecyclerView = recyclerView
    }

    fun notifyItemChangedWithCrashHandling(position: Int) {
        if (parentRecyclerView != null) {
            if (!parentRecyclerView!!.isComputingLayout) {
                parentRecyclerView!!.post { notifyItemChanged(position) }
            } else {
                notifyItemChangedWithCrashHandling(position)
            }
        } else {
            notifyItemChanged(position)
        }
    }

    fun notifyDataSetChangedWithCrashHandling() {
        try {
            if (parentRecyclerView != null) {
                parentRecyclerView!!.post { notifyDataSetChanged() }
            } else {
                notifyDataSetChanged()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
