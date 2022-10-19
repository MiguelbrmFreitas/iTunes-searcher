package com.miguelbrmfreitas.data.remote.mappers

import com.miguelbrmfreitas.data.remote.response.SearchResultResponse
import com.miguelbrmfreitas.domain.entities.SearchResult
import com.miguelbrmfreitas.domain.util.extensions.toFormattedDate
import com.miguelbrmfreitas.domain.util.extensions.toDate
import com.miguelbrmfreitas.domain.util.extensions.toPrice

fun SearchResultResponse.toDomainEntity(): SearchResult {
    return SearchResult(
        artistName = artistName,
        imageCoverUrl = imageCoverUrl,
        previewUrl = previewUrl,
        trackName = trackName,
        trackId = trackId,
        albumName = albumName,
        releaseDate = releaseDate.toDate(),
        formattedDate = releaseDate.toFormattedDate(),
        primaryGenreName = primaryGenreName,
        formattedPrice = trackPrice.toPrice()
    )
}