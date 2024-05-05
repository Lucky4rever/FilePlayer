package com.fileplayer.engine.logic

import android.content.Context
import android.net.Uri

class MediaPlayer(context: Context) : Player {
    private val player = android.widget.VideoView(context)
    private var uri: Uri? = null

    override fun play() {
        player.start()
    }

    override fun pause() {
        player.pause()
    }

    override fun stop() {
        player.stopPlayback()

        uri = null
    }

    override fun setUri(uri: Uri?) {
        this.uri = uri

        if (uri == null) return
        player.setVideoURI(uri)
        player.requestFocus()
    }

    override fun getUri(): Uri? = uri

    fun getPlayer() = player
}