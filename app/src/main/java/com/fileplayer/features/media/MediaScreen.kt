package com.fileplayer.features.media

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fileplayer.engine.logic.AudioPlayer
import com.fileplayer.engine.logic.MediaPlayer
import com.fileplayer.features.media.components.MediaPlayerComponent

@Composable
fun MediaScreen(
    component: MediaComponent
) {
    val player by remember { mutableStateOf(MediaPlayer(component.context)) }
    var uri by remember { mutableStateOf<Uri?>(null) }
    val getContent = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
        uri = it
        player.setUri(uri)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Media Screen")
        Button(onClick = component::toHomePage) {
            Text(text = "Go back")
        }

        Button(
            onClick = { getContent.launch("*/*") },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Відкрити")
        }

        MediaPlayerComponent(player, player.getPlayer(), uri)
    }
}