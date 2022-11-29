package com.bhi.commonlib.widgets.recyclerview.itemdecorator

import android.graphics.Rect
import android.view.View

/**
 * Shows provided spacing in RecyclerView component horizontally.
 */
class ItemDecorationListHorizontal(private val space: Int,
                                   private val topBottomSpacing: Boolean = false,
                                   private val leftRightSpacing: Boolean = false,
                                   private val leftOnlySpacing: Boolean = false,
                                   private val rightOnlySpacing: Boolean = false) : androidx.recyclerview.widget.RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: androidx.recyclerview.widget.RecyclerView, state: androidx.recyclerview.widget.RecyclerView.State) {
        val position = parent.getChildLayoutPosition(view)
        val childCount = parent.adapter?.itemCount
                ?: 0

        if (topBottomSpacing) {
            outRect.top = space
            outRect.bottom = space
        } else {
            outRect.top = 0
            outRect.bottom = 0
        }

        when {
            leftRightSpacing -> {
                outRect.left = if (position == 0) {
                    space
                } else {
                    0
                }
                outRect.right = space
            }
            leftOnlySpacing -> {
                outRect.left = space
                outRect.right = 0
            }
            rightOnlySpacing -> {
                outRect.left = 0
                outRect.right = space
            }
            else -> {
                outRect.left = 0
                outRect.right = if (position < childCount - 1) {
                    space
                } else {
                    0
                }
            }
        }
    }
}