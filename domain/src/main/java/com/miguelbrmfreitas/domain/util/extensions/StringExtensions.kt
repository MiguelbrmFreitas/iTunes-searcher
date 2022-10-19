package com.miguelbrmfreitas.domain.util.extensions

import java.text.SimpleDateFormat
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.*

const val FORMATTED_DATE_PATTERN = "MMM dd, uuuu"
const val API_DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'"

fun String.replaceSpaces(): String {
    return replace(' ', '+')
}

fun String.toDate(): Date {
    val format = SimpleDateFormat(API_DATE_PATTERN, Locale.US)
    return format.parse(this)
}

fun String.toFormattedDate(): String {
    val offsetDateTime = OffsetDateTime.parse(this)
    val formatter = DateTimeFormatter.ofPattern(FORMATTED_DATE_PATTERN, Locale.ENGLISH)
    return formatter.format(offsetDateTime)
}