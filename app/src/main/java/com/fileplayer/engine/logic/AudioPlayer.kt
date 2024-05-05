package com.fileplayer.engine.logic

import android.content.Context
import android.net.Uri

class AudioPlayer(private val context: Context) : Player {
    private val audioPlayer = android.media.MediaPlayer()
    private var uri: Uri? = null

    override fun play() {
        audioPlayer.start()
    }

    override fun pause() {
        audioPlayer.pause()
    }

    override fun stop() {
        audioPlayer.stop()

        uri = null
    }

    override fun setUri(uri: Uri?) {
        this.uri = uri

        if (uri == null) return
        audioPlayer.apply {
            setDataSource(context, uri)
            prepare()
        }
    }

    override fun getUri(): Uri? = uri
}