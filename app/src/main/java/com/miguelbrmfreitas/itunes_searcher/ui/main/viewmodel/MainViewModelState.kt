package com.miguelbrmfreitas.itunes_searcher.ui.main.viewmodel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class MainViewModelState(
    private val isProgressVisible: MutableStateFlow<Boolean> = MutableStateFlow(true)
)