package com.bhi.commonlib.util.tooltip

import android.view.View
import com.skydoves.balloon.Balloon

class Tooltip(private val balloon: Balloon) {
    fun show(view: View, tooltipPosition: TooltipPosition) {
        when (tooltipPosition) {
            TooltipPosition.LEFT -> {
                balloon.showAlignLeft(view)
            }
            TooltipPosition.TOP -> {
                balloon.showAlignTop(view)
            }
            TooltipPosition.RIGHT -> {
                balloon.showAlignRight(view)
            }
            TooltipPosition.BOTTOM -> {
                balloon.showAlignBottom(view)
            }
        }
    }
}