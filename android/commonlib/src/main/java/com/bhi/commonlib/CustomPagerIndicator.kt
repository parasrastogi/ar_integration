package com.bhi.commonlib

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.custom_pager_inidicator.view.*

open class CustomPagerIndicator : FrameLayout, androidx.viewpager.widget.ViewPager.OnPageChangeListener {
    override fun onPageScrollStateChanged(state: Int) {
        //Left blank intentionally
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        //Left blank intentionally
    }

    override fun onPageSelected(position: Int) {
        if (viewPager == null
                || viewPager!!.adapter == null) {
            return
        }
        tv_current_item.text = (position + 1).toString()
        tv_total_item.text = viewPager!!.adapter!!.count.toString()
    }

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    protected open fun init() {
        LayoutInflater.from(context).inflate(R.layout.custom_pager_inidicator, this, true)
        ll_slideshow_page_counter.visibility = View.GONE
    }

    private var viewPager: androidx.viewpager.widget.ViewPager? = null

    fun setViewPager(viewPager: androidx.viewpager.widget.ViewPager?) {
        this.viewPager = viewPager
        if (viewPager != null) {
            this.viewPager!!.addOnPageChangeListener(this)
            ll_slideshow_page_counter.visibility = View.VISIBLE
            onPageSelected(0)
        } else {
            ll_slideshow_page_counter.visibility = View.GONE
        }
    }
}