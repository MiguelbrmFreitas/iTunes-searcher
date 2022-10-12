package com.miguelbrmfreitas.itunes_searcher.ui.main.viewmodel

import com.miguelbrmfreitas.domain.usecases.GetResultsUseCase
import com.miguelbrmfreitas.itunes_searcher.ui.base.BaseViewModel

class MainViewModel(
    private val getResultsUseCase: GetResultsUseCase,
    val mainViewModelState: MainViewModelState
) : BaseViewModel() {
    override fun startView() {

    }
}