package com.miguelbrmfreitas.data.remote

import com.miguelbrmfreitas.domain.entities.SearchResult

data class ResultsApiResponse(
    val resultCount: Int,
    val results: List<SearchResult>
)