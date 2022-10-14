package com.miguelbrmfreitas.data.remote

import com.miguelbrmfreitas.domain.entities.SearchResult
import com.miguelbrmfreitas.domain.repository.CustomResponse
import com.miguelbrmfreitas.domain.repository.ItunesSearcherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.http.Query
import java.lang.Exception

class ItunesSearcherRepositoryImpl (private val service: ItunesSearcherService) : ItunesSearcherRepository
{
    override suspend fun getSearchResults
    (
        searchTerm: String,
        mediaType: String,
        entity: String,
        limit: Int
    ): CustomResponse<List<SearchResult>> =
        withContext(Dispatchers.IO) {
            val response = service.getSearchResults(searchTerm, mediaType, entity, limit)

            if (response.isSuccessful) {
                response.body()?.results?.let { searchResults ->
                    return@withContext CustomResponse.Success(searchResults)
                } ?: kotlin.run {
                    return@withContext CustomResponse.Failure(Exception(response.message()))
                }
            } else {
                return@withContext CustomResponse.Failure(Exception(response.message()))
            }
        }

}