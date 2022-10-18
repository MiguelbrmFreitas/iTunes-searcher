package com.miguelbrmfreitas.itunes_searcher.ui.main.viewmodel

import androidx.lifecycle.viewModelScope
import com.miguelbrmfreitas.domain.repository.CustomResponse
import com.miguelbrmfreitas.domain.usecases.GetResultsUseCase
import com.miguelbrmfreitas.itunes_searcher.ui.base.BaseViewModel
import com.miguelbrmfreitas.itunes_searcher.ui.main.adapter.SearchResultAdapter
import com.miguelbrmfreitas.itunes_searcher.ui.util.components.RecyclerComponent
import kotlinx.coroutines.launch

class MainViewModel(
    private val getResultsUseCase: GetResultsUseCase,
    val mainViewModelState: MainViewModelState
) : BaseViewModel() {

    private val searchResultListAdapter by lazy { SearchResultAdapter() }


    override fun startView() {

    }

    private fun getSearchResults(searchTerm: String) {
        viewModelScope.launch {
            when (val response = getResultsUseCase.invoke(searchTerm)) {
                is CustomResponse.Success -> {
                    response.data.let { searchResultsList ->
                        mainViewModelState.apply {
                            recyclerSearchResults.value = RecyclerComponent(
                                adapter = searchResultListAdapter
                            )

                            isProgressVisible.value = false
                        }

                        searchResultListAdapter.searchResultList = searchResultsList

                    }
                }
                is CustomResponse.Failure -> {
                    mainViewModelState.isProgressVisible.value = false
                }
            }

        }
    }

    fun onSearchClicked() {
        mainViewModelState.apply {
            val searchTerm = searchTermText.value // Two-way data binding

            if (searchTerm.isNotEmpty()) {
                isProgressVisible.value = true
                getSearchResults(searchTerm)
            }
        }
    }
}