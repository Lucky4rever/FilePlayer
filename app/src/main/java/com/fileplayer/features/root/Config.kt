package com.fileplayer.features.root

import com.arkivanov.essenty.parcelable.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.IgnoredOnParcel

sealed interface Config : Parcelable {

    val isTab: Boolean
        get() = false

    @Parcelize
    data object Home : Config {
        @IgnoredOnParcel
        override val isTab = true
    }

    @Parcelize
    data object Audio : Config {
        @IgnoredOnParcel
        override val isTab = true
    }

    @Parcelize
    data object Media : Config {
        @IgnoredOnParcel
        override val isTab = true
    }
}