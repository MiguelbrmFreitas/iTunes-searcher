package com.miguelbrmfreitas.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ItunesSearcherService
{
    @GET("search")
    suspend fun getSearchResults(
        @Query("term") searchTerm: String,
        @Query("media") mediaType: String,
        @Query("entity") entity: String,
        @Query("limit") limit: Int
    ): Response<ResultsApiResponse>
}