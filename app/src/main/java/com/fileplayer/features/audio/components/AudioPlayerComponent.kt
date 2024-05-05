package com.fileplayer.features.audio.components

import android.net.Uri
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.fileplayer.engine.logic.Player

@Composable
fun AudioPlayerComponent(
    player: Player,
    uri: Uri?
) {
    if (uri == null) return

    Row {
        Button(onClick = player::play) {
            Text("Play")
        }
        Button(onClick = player::pause) {
            Text("Pause")
        }
        Button(onClick = player::stop) {
            Text("Stop")
        }
    }
}