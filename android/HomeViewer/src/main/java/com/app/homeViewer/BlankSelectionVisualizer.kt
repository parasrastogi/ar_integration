package com.app.homeViewer

import com.google.ar.sceneform.ux.BaseTransformableNode
import com.google.ar.sceneform.ux.SelectionVisualizer

/**
 * This is a blank visualizer. This will help in removing the default circle at bottom of 3D model when get selected
 * by click or any other gesture.
 */
class BlankSelectionVisualizer : SelectionVisualizer {
    override fun applySelectionVisual(var1: BaseTransformableNode) {}
    override fun removeSelectionVisual(var1: BaseTransformableNode) {}
}