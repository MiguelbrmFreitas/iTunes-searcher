package com.miguelbrmfreitas.domain.usecases

import com.miguelbrmfreitas.domain.repository.ItunesSearcherRepository
import com.miguelbrmfreitas.domain.util.extensions.replaceSpaces

class GetResultsUseCase (private val repository: ItunesSearcherRepository)
{
    companion object {
        const val RESULTS_LIMIT = 30
        const val MEDIA_TYPE = "music"
        const val MEDIA_ENTITY = "song"
    }

    suspend operator fun invoke
    (
        searchTerm: String,
        mediaType: String = MEDIA_TYPE,
        entity: String = MEDIA_ENTITY,
        limit: Int = RESULTS_LIMIT
    ) =
        repository.getSearchResults(
            searchTerm.replaceSpaces(),
            mediaType,
            entity,
            limit
        )
}