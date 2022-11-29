package com.bhi.commonlib.widgets

import android.widget.BaseAdapter
import com.bhi.commonlib.widgets.recyclerview.OnItemClickListener
import java.util.*
import kotlin.collections.ArrayList


abstract class BaseListAdapter<T> : BaseAdapter() {

    var allItems: ArrayList<T> = ArrayList()
    var onItemClickListener: OnItemClickListener<T>? = null

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

    override fun getCount(): Int {
        return allItems.size
    }

    override fun getItem(position: Int): T? {
        return allItems.getOrNull(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }
}