package com.miguelbrmfreitas.domain.repository

import com.miguelbrmfreitas.domain.entities.SearchResult

interface ItunesSearcherRepository
{
    suspend fun getSearchResults(): CustomResponse<List<SearchResult>>
}