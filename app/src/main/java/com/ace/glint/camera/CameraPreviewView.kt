package com.ace.glint.camera

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.camera.view.PreviewView

class CameraPreviewView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {
    private val previewView: PreviewView
    private val glOverlay : GLPreviewOverlay

    init {
        previewView = PreviewView(context, attrs)
        glOverlay = GLPreviewOverlay(context)
        addView(previewView, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT))
        addView(glOverlay, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT))

    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        CameraController.bindPreview(previewView, glOverlay)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        CameraController.unbind()
    }
}