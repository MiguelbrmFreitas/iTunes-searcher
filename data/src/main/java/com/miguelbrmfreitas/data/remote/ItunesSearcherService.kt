package com.miguelbrmfreitas.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface ItunesSearcherService
{
    @GET("search")
    suspend fun getSearchResults(): Response<ResultsApiResponse>
}