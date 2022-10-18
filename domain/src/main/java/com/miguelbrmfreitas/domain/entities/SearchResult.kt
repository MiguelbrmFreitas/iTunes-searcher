package com.miguelbrmfreitas.domain.entities

data class SearchResult(
    val artistName: String,
    val artworkUrl100: String,
    val previewUrl: String,
    val trackName: String,
    val trackId: Int
)