package com.ace.glint.camera

import android.content.Context
import android.opengl.GLSurfaceView
import android.util.AttributeSet
import com.ace.glint.render.RenderEngine

class GLPreviewOverlay @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : GLSurfaceView(context, attrs) {
    private val renderer: RenderEngine

    init {
        setEGLContextClientVersion(2)
        renderer = RenderEngine(context)
        setRenderer(renderer)
        renderMode = RENDERMODE_WHEN_DIRTY
    }

    fun updateFrame() {
        requestRender()
    }
}