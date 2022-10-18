package com.miguelbrmfreitas.domain.util.extensions

import java.util.Date

fun String.replaceSpaces(): String {
    return replace(' ', '+')
}

fun String.toDate(): Date {
    return Date()
}