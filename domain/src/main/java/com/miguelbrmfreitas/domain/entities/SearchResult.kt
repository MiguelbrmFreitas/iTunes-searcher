package com.miguelbrmfreitas.domain.entities

import java.time.LocalDateTime
import java.util.Date

data class SearchResult(
    val artistName: String,
    val imageCoverUrl: String,
    val previewUrl: String, // May be used later to play the preview song
    val trackName: String,
    val trackId: Int,
    val albumName: String,
    val releaseDate: LocalDateTime, // May be used later if we want to sort by release date
    val formattedDate: String,
    val primaryGenreName: String,
    val formattedPrice: String
)