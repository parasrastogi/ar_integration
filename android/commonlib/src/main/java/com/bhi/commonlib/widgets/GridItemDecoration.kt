package com.bhi.commonlib.widgets

import android.graphics.Rect
import android.view.View

import androidx.recyclerview.widget.RecyclerView

/**
 * Provides spacing in grid items of RecyclerView component.
 */
class GridItemDecoration(private val spanCount: Int, private val horizontalSpacing: Int, private val verticalSpacing: Int, private val includeEdge: Boolean) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildAdapterPosition(view)
        val column = position % spanCount

        if (includeEdge) {
            outRect.left = horizontalSpacing - column * horizontalSpacing / spanCount
            outRect.right = (column + 1) * horizontalSpacing / spanCount
            outRect.bottom = verticalSpacing // item bottom
        } else {
            outRect.left = column * horizontalSpacing / spanCount
            outRect.right = horizontalSpacing - (column + 1) * horizontalSpacing / spanCount
            outRect.top = verticalSpacing
        }
    }
}