package com.fileplayer.features.audio

import android.content.Context
import com.fileplayer.engine.utils.Consumer

class AudioComponentImpl(
    override val context: Context,
    private val output: Consumer<AudioOutput>,
) : AudioComponent {
    override fun toHomePage() =
        output(AudioOutput.Home)
}