package com.miguelbrmfreitas.data.remote.response

data class SearchResultListResponse(
    val resultCount: Int,
    val results: List<SearchResultResponse>
)