package com.bhi.commonlib.widgets

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.style.DynamicDrawableSpan
import android.text.style.ImageSpan
import androidx.annotation.DrawableRes
import java.lang.ref.WeakReference

class CenteredImageSpan @JvmOverloads constructor(context: Context, @DrawableRes drawableResourceId: Int,
                                                  verticalAlignment: Int = DynamicDrawableSpan.ALIGN_BASELINE)
    : ImageSpan(context, drawableResourceId, verticalAlignment) {

    // Extra variables used to redefine the Font Metrics when an ImageSpan is added
    private var initialDescent = 0
    private var extraSpace = 0
    private var mDrawableRef: WeakReference<Drawable>? = null

    // Redefined locally because it is a private member from DynamicDrawableSpan
    private val cachedDrawable: Drawable?
        get() {
            val wr = mDrawableRef
            var d: Drawable? = null

            if (wr != null)
                d = wr.get()

            if (d == null) {
                d = drawable
                mDrawableRef = WeakReference(d)
            }

            return d
        }

    override fun draw(canvas: Canvas, text: CharSequence,
                      start: Int, end: Int, x: Float,
                      top: Int, y: Int, bottom: Int, paint: Paint) {
        drawable.draw(canvas)
    }

    // Method used to redefined the Font Metrics when an ImageSpan is added
    override fun getSize(paint: Paint, text: CharSequence,
                         start: Int, end: Int,
                         fm: Paint.FontMetricsInt?): Int {
        val d = cachedDrawable
        val rect = d!!.bounds

        if (fm != null) {
            // Centers the text with the ImageSpan
            if (rect.bottom - (fm.descent - fm.ascent) >= 0) {
                // Stores the initial descent and computes the margin available
                initialDescent = fm.descent
                extraSpace = rect.bottom - (fm.descent - fm.ascent)
            }

            fm.descent = extraSpace / 2 + initialDescent
            fm.bottom = fm.descent

            fm.ascent = -rect.bottom + fm.descent
            fm.top = fm.ascent
        }

        return rect.right
    }
}