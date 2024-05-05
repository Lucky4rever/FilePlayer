package com.fileplayer.features.audio

sealed interface AudioOutput {
    data object Home : AudioOutput
}