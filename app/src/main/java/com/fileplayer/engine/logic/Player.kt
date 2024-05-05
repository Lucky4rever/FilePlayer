package com.fileplayer.engine.logic

import android.net.Uri

interface Player {
    fun play() {}

    fun pause() {}

    fun stop() {}


    fun setUri(uri: Uri?)
    fun getUri(): Uri?
}