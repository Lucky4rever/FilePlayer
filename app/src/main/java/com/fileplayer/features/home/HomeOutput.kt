package com.fileplayer.features.home

sealed interface HomeOutput {
    data object Audio : HomeOutput

    data object Media : HomeOutput
}