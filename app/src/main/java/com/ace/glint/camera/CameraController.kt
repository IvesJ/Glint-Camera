package com.ace.glint.camera

import android.util.Log
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import com.ace.glint.TAG

object CameraController {
    private var cameraProvider: ProcessCameraProvider? = null

    fun bindPreview(previewView: PreviewView, glOverlay: GLPreviewOverlay) {
        val ctx = previewView.context
        val cameraProviderFuture = ProcessCameraProvider.getInstance(ctx)
        cameraProviderFuture.addListener({
            cameraProvider = cameraProviderFuture.get()
            val preview = Preview.Builder().build().also {
                it.setSurfaceProvider(previewView.surfaceProvider)
            }
            try {
                cameraProvider?.unbindAll()
                cameraProvider?.bindToLifecycle(
                    ctx as LifecycleOwner,
                    CameraSelector.DEFAULT_BACK_CAMERA,
                    preview
                )
            } catch (e: Exception) {
                Log.e(TAG, "bindPreview fail, $e")
            }
        }, ContextCompat.getMainExecutor(ctx))
    }

    fun unbind() {
        cameraProvider?.unbindAll()
    }
}