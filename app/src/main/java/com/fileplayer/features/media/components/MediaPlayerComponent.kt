package com.fileplayer.features.media.components

import android.net.Uri
import android.widget.VideoView
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.fileplayer.engine.logic.Player

@Composable
fun MediaPlayerComponent(
    player: Player,
    videoView: VideoView,
    uri: Uri?
) {
    var rememberableUri by remember { mutableStateOf(uri) }
    if (rememberableUri == null && uri == null) return

    AndroidView(
        factory = { videoView },
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(16f / 9f)
    ) { view ->
        player.setUri(uri)
        view.setVideoURI(uri)
        view.requestFocus()
    }

    Row {
        Button(onClick = player::play) {
            Text("Play")
        }
        Button(onClick = player::pause) {
            Text("Pause")
        }
        Button(onClick = {
            player.stop()
            rememberableUri = null
        }) {
            Text("Stop")
        }
    }
}