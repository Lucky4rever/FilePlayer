package com.fileplayer.features.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.fileplayer.engine.config.TabConfig
import com.fileplayer.features.audio.AudioComponent
import com.fileplayer.features.home.HomeComponent
import com.fileplayer.features.media.MediaComponent

interface RootComponent {
    val stack: Value<ChildStack<*, Child>>
    val screenProvider: ScreenProvider

    fun onTabClicked(tab: TabConfig) {}

    sealed class Child(val tab: TabConfig? = null) : Screen {
        data class Home(val component: HomeComponent) : Child(TabConfig.HOME)
        data class Audio(val component: AudioComponent) : Child(TabConfig.AUDIO)
        data class Media(val component: MediaComponent) : Child(TabConfig.MEDIA)
    }
}