package com.miguelbrmfreitas.domain.repository

import com.miguelbrmfreitas.domain.entities.SearchResult

interface ItunesSearcherRepository
{
    suspend fun getSearchResults(
        searchTerm: String,
        mediaType: String,
        entity: String,
        limit: Int
    ): CustomResponse<List<SearchResult>>
}