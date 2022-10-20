package com.miguelbrmfreitas.itunes_searcher.ui.main.viewmodel

import androidx.lifecycle.viewModelScope
import com.miguelbrmfreitas.domain.entities.SearchResult
import com.miguelbrmfreitas.domain.repository.CustomResponse
import com.miguelbrmfreitas.domain.usecases.GetResultsUseCase
import com.miguelbrmfreitas.itunes_searcher.ui.base.BaseViewModel
import com.miguelbrmfreitas.itunes_searcher.ui.main.adapter.SearchResultAdapter
import com.miguelbrmfreitas.itunes_searcher.ui.main.listeners.IResultClickListener
import com.miguelbrmfreitas.itunes_searcher.ui.util.components.RecyclerComponent
import kotlinx.coroutines.launch

class MainViewModel(
    private val getResultsUseCase: GetResultsUseCase,
    val mainViewModelState: MainViewModelState
) : BaseViewModel(), IResultClickListener {

    private val searchResultListAdapter by lazy { SearchResultAdapter(this) }

    var selectedResult: SearchResult? = null
        private set

    override fun startView() {
        mainViewModelState.searchTermText.value = ""
    }

    private fun getSearchResults(searchTerm: String) {
        viewModelScope.launch {
            when (val response = getResultsUseCase.invoke(searchTerm)) {
                is CustomResponse.Success -> {
                    response.data.let { searchResultsList ->
                        mainViewModelState.apply {
                            isProgressVisible.value = false

                            resultsCount.value = searchResultsList.size
                            if (searchResultsList.isNotEmpty()) {
                                recyclerSearchResults.value = RecyclerComponent(
                                    adapter = searchResultListAdapter
                                )
                                setEmptyState(false)
                                searchResultListAdapter.searchResultList = searchResultsList

                            } else {
                                setEmptyState(true)
                            }
                        }

                    }
                }
                is CustomResponse.Failure -> {
                    mainViewModelState.isProgressVisible.value = false
                    setEmptyState(true)
                }
            }

        }
    }

    fun onSearchClicked() {
        mainViewModelState.apply {
            val searchTerm = searchTermText.value // Two-way data binding

            if (searchTerm.isNotEmpty()) {
                isProgressVisible.value = true
                isShowingResults.value = false
                getSearchResults(searchTerm)
            }
        }
    }

    override fun onResultClicked(searchResult: SearchResult) {
        selectedResult = searchResult
        mainViewModelState.hasToShowBottomSheet.value = true
    }

    private fun setEmptyState(hasToShowEmptyState: Boolean) {
        mainViewModelState.apply {
            isShowingResults.value = !hasToShowEmptyState
            isEmptyStateVisible.value = hasToShowEmptyState
        }
    }
}