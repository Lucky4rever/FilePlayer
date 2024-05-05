package com.fileplayer.features.root

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.fileplayer.features.audio.AudioScreen
import com.fileplayer.features.home.HomeScreen
import com.fileplayer.features.media.MediaScreen
import com.fileplayer.features.root.RootComponent.Child

class ScreenProviderImpl : ScreenProvider {
    @Composable
    override fun GetScreen(screen: Screen) =
        when (screen) {
            is Child.Home -> HomeScreen(screen.component)
            is Child.Audio -> AudioScreen(screen.component)
            is Child.Media -> MediaScreen(screen.component)

            else -> Box(contentAlignment = Alignment.Center) {
                Text("No Screen associated with $screen")
            }
        }
}