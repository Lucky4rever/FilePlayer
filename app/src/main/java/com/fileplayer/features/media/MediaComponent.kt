package com.fileplayer.features.media

import android.content.Context

interface MediaComponent {
    val context: Context

    fun toHomePage()
}