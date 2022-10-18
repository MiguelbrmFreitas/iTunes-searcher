package com.miguelbrmfreitas.domain.util.extensions

import java.text.SimpleDateFormat
import java.util.*

fun String.replaceSpaces(): String {
    return replace(' ', '+')
}

fun String.toDate(): Date {
    val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US)
    return format.parse(this)
}