package com.miguelbrmfreitas.itunes_searcher.ui.main.viewmodel

import com.miguelbrmfreitas.itunes_searcher.ui.util.components.RecyclerComponent
import kotlinx.coroutines.flow.MutableStateFlow

data class MainViewModelState(
    val isProgressVisible: MutableStateFlow<Boolean> = MutableStateFlow(true),
    val recyclerSearchResults: MutableStateFlow<RecyclerComponent> = MutableStateFlow(RecyclerComponent())
)