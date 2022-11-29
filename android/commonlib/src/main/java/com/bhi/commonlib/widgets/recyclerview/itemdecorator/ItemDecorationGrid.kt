package com.bhi.commonlib.widgets.recyclerview.itemdecorator

import android.graphics.Rect
import android.view.View

class ItemDecorationGrid(private val spanCount: Int, private val spacing: Int, private val includeEdge: Boolean,
                         private val setForFistItemToo: Boolean = true) : androidx.recyclerview.widget.RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: androidx.recyclerview.widget.RecyclerView, state: androidx.recyclerview.widget.RecyclerView.State) {
        val position = parent.getChildAdapterPosition(view) // item position
        val column = position % spanCount // item column

        if (includeEdge) {
            outRect.left = spacing - column * spacing / spanCount // spacing - column * ((1f / spanCount) * spacing)
            outRect.right = (column + 1) * spacing / spanCount // (column + 1) * ((1f / spanCount) * spacing)
            outRect.bottom = spacing // item bottom

            if (position < spanCount && setForFistItemToo) { // top edge
                outRect.top = spacing
            }
        } else {
            outRect.left = column * spacing / spanCount // column * ((1f / spanCount) * spacing)
            outRect.right = spacing - (column + 1) * spacing / spanCount // spacing - (column + 1) * ((1f /    spanCount) * spacing)
            if (position >= spanCount) {
                outRect.top = spacing // item top
            }
        }
    }
}