package com.fileplayer.features.root

import androidx.compose.runtime.Composable

interface Screen

interface ScreenProvider {
    @Composable
    fun GetScreen(screen: Screen)
}
