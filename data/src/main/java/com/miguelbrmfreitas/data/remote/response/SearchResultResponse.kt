package com.miguelbrmfreitas.data.remote.response

import com.squareup.moshi.Json

data class SearchResultResponse(
    val artistName: String,
    @Json(name = "artworkUrl100")
    val imageCoverUrl: String,
    val previewUrl: String,
    val trackName: String,
    val trackId: Int,
    @Json(name="collectionName")
    val albumName: String,
    val releaseDate: String,
    val primaryGenreName: String
)