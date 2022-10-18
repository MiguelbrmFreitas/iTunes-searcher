package com.miguelbrmfreitas.domain.entities

import java.util.Date

data class SearchResult(
    val artistName: String,
    val imageCoverUrl: String,
    val previewUrl: String,
    val trackName: String,
    val trackId: Int,
    val albumName: String,
    val releaseDate: Date,
    val primaryGenreName: String
)