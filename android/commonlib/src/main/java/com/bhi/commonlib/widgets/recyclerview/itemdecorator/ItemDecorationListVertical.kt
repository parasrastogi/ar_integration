package com.bhi.commonlib.widgets.recyclerview.itemdecorator

import android.graphics.Rect
import android.view.View

/**
 * Shows provided spacing in RecyclerView component horizontally.
 */
open class ItemDecorationListVertical(
        private val space: Int,
        private val leftRightSpacing: Boolean = false,
        private val topBottomSpacing: Boolean = false,
        private val topOnlySpacing: Boolean = false,
        private val bottomOnlySpacing: Boolean = false,
        private val lastItemBottomSpacing: Int = 0)
    : androidx.recyclerview.widget.RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: androidx.recyclerview.widget.RecyclerView, state: androidx.recyclerview.widget.RecyclerView.State) {
        val position = parent.getChildLayoutPosition(view)
        val childCount = parent.adapter?.itemCount
                ?: 0

        if (leftRightSpacing) {
            outRect.left = space
            outRect.right = space
        } else {
            outRect.left = 0
            outRect.right = 0
        }

        when {
            topBottomSpacing -> {
                outRect.top = if (position == 0) {
                    space
                } else {
                    0
                }
                outRect.bottom = space
            }
            topOnlySpacing -> {
                outRect.top = space
                outRect.bottom = 0
            }
            bottomOnlySpacing -> {
                outRect.top = 0
                outRect.bottom = space
            }
            else -> {
                outRect.top = 0

                outRect.bottom = if (position < childCount - 1) {
                    space
                } else {
                    0
                }
            }
        }

        if (lastItemBottomSpacing > 0 && position == (childCount - 1)) {
            outRect.bottom = lastItemBottomSpacing
        }
    }
}