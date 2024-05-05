package com.fileplayer.features.media

sealed interface MediaOutput {
    data object Home : MediaOutput
}