package com.fileplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import com.fileplayer.features.root.RootComponent
import com.fileplayer.features.root.RootComponentImpl
import com.fileplayer.features.root.RootScreen

class MainActivity : ComponentActivity() {
    private val rootComponent: RootComponent by lazy {
        RootComponentImpl(
            context = applicationContext,
            componentContext = defaultComponentContext()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RootScreen(component = rootComponent)
        }
    }
}