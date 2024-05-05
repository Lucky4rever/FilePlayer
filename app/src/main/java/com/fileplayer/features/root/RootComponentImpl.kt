package com.fileplayer.features.root

import android.content.Context
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.fileplayer.engine.config.TabConfig
import com.fileplayer.features.audio.AudioComponent
import com.fileplayer.features.audio.AudioComponentImpl
import com.fileplayer.features.home.HomeComponent
import com.fileplayer.features.home.HomeComponentImpl
import com.fileplayer.features.media.MediaComponent
import com.fileplayer.features.media.MediaComponentImpl
import com.fileplayer.features.root.RootComponent.Child

class RootComponentImpl(
    context: Context,
    componentContext: ComponentContext,
) : RootComponent, ComponentContext by componentContext {
    private val navigation = StackNavigation<Config>()

    override val screenProvider: ScreenProvider by lazy { ScreenProviderImpl() }

    override fun onTabClicked(tab: TabConfig) =
        when (tab) {
            TabConfig.HOME -> Config.Home
            TabConfig.AUDIO -> Config.Audio
            TabConfig.MEDIA -> Config.Media
        }.let {
            navigation.bringToFront(it)
        }

    private val homeComponent: HomeComponent by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        HomeComponentImpl { navigation.onHomeOutput(it) }
    }

    private val audioComponent: AudioComponent by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        AudioComponentImpl(context) { navigation.onAudioOutput(it) }
    }

    private val mediaComponent: MediaComponent by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        MediaComponentImpl(context) { navigation.onMediaOutput(it) }
    }

    override val stack =
        childStack(
            source = navigation,
            initialConfiguration = Config.Home,
            handleBackButton = true,
            childFactory = ::factory
        )

    private fun factory(config: Config, componentContext: ComponentContext) =
        when (config) {
            Config.Home -> Child.Home(homeComponent)
            Config.Audio -> Child.Audio(audioComponent)
            Config.Media -> Child.Media(mediaComponent)
        }
}