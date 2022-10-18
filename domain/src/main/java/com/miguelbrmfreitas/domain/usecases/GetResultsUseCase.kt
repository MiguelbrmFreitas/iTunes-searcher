package com.miguelbrmfreitas.domain.usecases

import com.miguelbrmfreitas.domain.repository.ItunesSearcherRepository
import com.miguelbrmfreitas.domain.util.extensions.replaceSpaces

class GetResultsUseCase (private val repository: ItunesSearcherRepository)
{
    suspend operator fun invoke
    (
        searchTerm: String,
        mediaType: String = "music",
        entity: String = "song",
        limit: Int = 100
    ) =
        repository.getSearchResults(
            searchTerm.replaceSpaces(),
            mediaType,
            entity,
            limit
        )
}