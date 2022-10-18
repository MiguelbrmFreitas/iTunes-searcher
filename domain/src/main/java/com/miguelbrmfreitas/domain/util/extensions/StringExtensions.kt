package com.miguelbrmfreitas.domain.util.extensions

fun String.replaceSpaces(): String {
    return replace(' ', '+')
}