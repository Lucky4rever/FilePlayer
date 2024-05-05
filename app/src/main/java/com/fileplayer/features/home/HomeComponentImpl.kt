package com.fileplayer.features.home

import com.fileplayer.engine.utils.Consumer

class HomeComponentImpl(
    private val output: Consumer<HomeOutput>,
) : HomeComponent {
    override fun openAudioPlayer() =
        output(HomeOutput.Audio)

    override fun openMediaPlayer() =
        output(HomeOutput.Media)
}