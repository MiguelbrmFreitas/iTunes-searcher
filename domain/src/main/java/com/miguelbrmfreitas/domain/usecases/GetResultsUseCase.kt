package com.miguelbrmfreitas.domain.usecases

import com.miguelbrmfreitas.domain.repository.ItunesSearcherRepository

class GetResultsUseCase (private val repository: ItunesSearcherRepository)
{
    suspend operator fun invoke() = repository.getSearchResults()
}