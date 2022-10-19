package com.miguelbrmfreitas.itunes_searcher.ui.util.extensions

import android.content.Context
import androidx.swiperefreshlayout.widget.CircularProgressDrawable

fun Context.createCircularProgressDrawable(): CircularProgressDrawable {
    val circularProgressDrawable = CircularProgressDrawable(this)
    circularProgressDrawable.strokeWidth = 5f
    circularProgressDrawable.centerRadius = 30f
    circularProgressDrawable.start()

    return circularProgressDrawable
}