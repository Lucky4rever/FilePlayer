package com.fileplayer.features.root

import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.fileplayer.features.audio.AudioOutput
import com.fileplayer.features.home.HomeOutput
import com.fileplayer.features.media.MediaOutput

internal fun StackNavigation<Config>.onHomeOutput(output: HomeOutput) =
    when (output) {
        HomeOutput.Audio -> push(Config.Audio)
        HomeOutput.Media -> push(Config.Media)
    }

internal fun StackNavigation<Config>.onAudioOutput(output: AudioOutput) =
    when (output) {
        AudioOutput.Home -> pop()
    }

internal fun StackNavigation<Config>.onMediaOutput(output: MediaOutput) =
    when (output) {
        MediaOutput.Home -> pop()
    }