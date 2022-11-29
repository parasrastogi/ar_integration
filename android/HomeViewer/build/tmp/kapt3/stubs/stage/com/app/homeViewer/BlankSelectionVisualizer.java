package com.app.homeViewer;

import java.lang.System;

/**
 * This is a blank visualizer. This will help in removing the default circle at bottom of 3D model when get selected
 * by click or any other gesture.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/app/homeViewer/BlankSelectionVisualizer;", "Lcom/google/ar/sceneform/ux/SelectionVisualizer;", "()V", "applySelectionVisual", "", "var1", "Lcom/google/ar/sceneform/ux/BaseTransformableNode;", "removeSelectionVisual", "HomeViewer_stage"})
public final class BlankSelectionVisualizer implements com.google.ar.sceneform.ux.SelectionVisualizer {
    
    public BlankSelectionVisualizer() {
        super();
    }
    
    @java.lang.Override()
    public void applySelectionVisual(@org.jetbrains.annotations.NotNull()
    com.google.ar.sceneform.ux.BaseTransformableNode var1) {
    }
    
    @java.lang.Override()
    public void removeSelectionVisual(@org.jetbrains.annotations.NotNull()
    com.google.ar.sceneform.ux.BaseTransformableNode var1) {
    }
}