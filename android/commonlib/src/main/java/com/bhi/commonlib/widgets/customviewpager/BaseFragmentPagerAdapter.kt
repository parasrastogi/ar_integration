package com.bhi.commonlib.widgets.customviewpager

import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.bhi.commonlib.util.BaseFragment
import java.util.*

/**
 * Created by ram on 7/10/16.
 */

abstract class BaseFragmentPagerAdapter<T>(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val mFragments: MutableMap<Int, BaseFragment>
    private val mItems: MutableList<T>

    init {
        mFragments = HashMap()
        mItems = ArrayList()
    }

    override fun getItemPosition(`object`: Any): Int {
        return PagerAdapter.POSITION_NONE
    }

    override fun getItem(position: Int): BaseFragment {
        return getFragment(mItems[position])
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val fragment = super.instantiateItem(container, position) as BaseFragment
        mFragments[position] = fragment
        return fragment
    }

    fun addItem(item: T) {
        mItems.add(item)
    }

    fun removeItem(position: Int) {
        if (position >= 0 && position < mItems.size) {
            mItems.removeAt(position)
            if (mFragments.containsKey(position)) {
                mFragments.remove(position)
            }
        }
    }

    fun clear() {
        mItems.clear()
        mFragments.clear()
    }

    override fun getCount(): Int {
        return mItems.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)
        mFragments.remove(position)
    }

    protected abstract fun getFragment(item: T): BaseFragment

    open fun getFragmentAtPosition(position: Int): BaseFragment? {
        return mFragments[position]
    }

    fun getItemAtPosition(position: Int): T? {
        return if (mItems.size > position) {
            mItems[position]
        } else null
    }
}
