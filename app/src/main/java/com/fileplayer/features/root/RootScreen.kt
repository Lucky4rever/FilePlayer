package com.fileplayer.features.root

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.fileplayer.ui.theme.FilePlayerTheme

@Composable
fun RootScreen(component: RootComponent) {
    FilePlayerTheme {
        Content(component)
    }
}

@Composable
private fun Content(component: RootComponent) {
    val stack by component.stack.subscribeAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.LightGray,
        contentColor = Color.Black,
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .systemBarsPadding(),
            ) {
                Children(
                    stack = stack,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    animation = stackAnimation()
                ) {
                    component.screenProvider.GetScreen(it.instance)
                }
            }
        }
    }
}
