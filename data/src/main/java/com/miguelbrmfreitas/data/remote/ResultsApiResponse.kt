package com.miguelbrmfreitas.data.remote

data class ResultsApiResponse(
    val resultCount: Int,
    val results: List<com.miguelbrmfreitas.domain.entities.Result>
)