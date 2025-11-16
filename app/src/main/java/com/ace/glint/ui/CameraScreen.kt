package com.ace.glint.ui

import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.ace.glint.camera.CameraPreviewView

@Composable
fun CameraScreen(modifier: Modifier = Modifier) {
    val ctx = LocalContext.current

    Column(modifier = modifier) {
        AndroidView(
            factory = { context ->
                CameraPreviewView(context).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        0
                    )
                }
            }, modifier = Modifier
                .weight(1f)
        )
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp), horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = {}) { Text("Filter") }
        Button(onClick = {}) { Text("Capture") }
    }
}