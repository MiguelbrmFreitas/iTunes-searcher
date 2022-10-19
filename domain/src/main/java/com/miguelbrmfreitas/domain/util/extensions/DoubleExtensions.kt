package com.miguelbrmfreitas.domain.util.extensions

fun Double.toPrice(): String {
    return "$${this}"
}