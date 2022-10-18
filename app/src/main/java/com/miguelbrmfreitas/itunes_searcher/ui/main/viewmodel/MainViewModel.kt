package com.miguelbrmfreitas.itunes_searcher.ui.main.viewmodel

import androidx.lifecycle.viewModelScope
import com.miguelbrmfreitas.data.remote.ResultsApiResponse
import com.miguelbrmfreitas.domain.repository.CustomResponse
import com.miguelbrmfreitas.domain.usecases.GetResultsUseCase
import com.miguelbrmfreitas.itunes_searcher.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class MainViewModel(
    private val getResultsUseCase: GetResultsUseCase,
    val mainViewModelState: MainViewModelState
) : BaseViewModel() {

    override fun startView() {

    }

    fun getSearchResults(searchTerm: String) {
        viewModelScope.launch {
            when (val response = getResultsUseCase.invoke(searchTerm)) {
                is CustomResponse.Success -> {

                }
                is CustomResponse.Failure -> {

                }
            }

        }
    }
}