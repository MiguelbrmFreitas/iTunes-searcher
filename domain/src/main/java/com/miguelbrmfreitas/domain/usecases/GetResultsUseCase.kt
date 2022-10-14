package com.miguelbrmfreitas.domain.usecases

import com.miguelbrmfreitas.domain.repository.ItunesSearcherRepository

class GetResultsUseCase (private val repository: ItunesSearcherRepository)
{
    suspend operator fun invoke
    (
        searchTerm: String,
        mediaType: String,
        entity: String,
        limit: Int
    ) = repository.getSearchResults(searchTerm, mediaType, entity, limit)
}