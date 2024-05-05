package com.fileplayer.engine.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns
import android.util.Log

@SuppressLint("Range")
fun getPath(context: Context, uri: Uri): String? {
    val scheme = uri.scheme
    if (scheme == "content") {
        context.contentResolver.query(uri, null, null, null, null)?.use { cursor ->
            if (cursor.moveToFirst()) {
                val columnIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)

                if (columnIndex < 0)
                    return null

                val displayName = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME))

                Log.i("MainActivity", "Display Name: $displayName")
                val filePathColumnIndex = cursor.getColumnIndex("_data")

                if (filePathColumnIndex != -1) {
                    val filePath = cursor.getString(filePathColumnIndex)
                    Log.i("MainActivity", "File Path: $filePath")
                    return filePath
                }
            }
        }
    } else if (scheme == "file") {
        return uri.path
    }

    return null
}