package com.fileplayer.features.media

import android.content.Context
import com.fileplayer.engine.utils.Consumer

class MediaComponentImpl(
    override val context: Context,
    private val output: Consumer<MediaOutput>,
) : MediaComponent {
    override fun toHomePage() =
        output(MediaOutput.Home)
}