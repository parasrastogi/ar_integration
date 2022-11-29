package com.bhi.commonlib.util.tooltip

import android.content.Context
import androidx.annotation.ColorRes
import com.bhi.commonlib.R
import com.skydoves.balloon.ArrowOrientation
import com.skydoves.balloon.ArrowPositionRules
import com.skydoves.balloon.BalloonAnimation
import com.skydoves.balloon.createBalloon

object TooltipUtil {

    fun getTooltip(context: Context, text: String, backgroundColor: Int, @ColorRes textColorRes: Int, tooltipPosition: TooltipPosition): Tooltip {
        val resources = context.resources
        val arrowOrientation = when (tooltipPosition) {
            TooltipPosition.LEFT -> {
                ArrowOrientation.RIGHT
            }
            TooltipPosition.TOP -> {
                ArrowOrientation.BOTTOM
            }
            TooltipPosition.RIGHT -> {
                ArrowOrientation.LEFT
            }
            TooltipPosition.BOTTOM -> {
                ArrowOrientation.TOP
            }
        }
        return Tooltip(createBalloon(context) {
            setArrowSize(10)
            setPadding(resources.getDimensionPixelSize(R.dimen.padding_tooltip))
            setCornerRadius(resources.getDimension(R.dimen.widget_corner_radius))
            setArrowPositionRules(ArrowPositionRules.ALIGN_ANCHOR)
            setArrowOrientation(arrowOrientation)
            setText(text)
            setDismissWhenClicked(true)
            setDismissWhenTouchOutside(true)
            setBalloonAnimation(BalloonAnimation.FADE)
            setTextColorResource(textColorRes)
            setTextSizeResource(R.dimen.text_size_tooltip)
            setBackgroundColor(backgroundColor)
        })
    }
}