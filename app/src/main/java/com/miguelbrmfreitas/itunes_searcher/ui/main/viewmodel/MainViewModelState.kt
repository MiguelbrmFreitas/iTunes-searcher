package com.miguelbrmfreitas.itunes_searcher.ui.main.viewmodel

import com.miguelbrmfreitas.itunes_searcher.ui.util.components.RecyclerComponent
import kotlinx.coroutines.flow.MutableStateFlow

data class MainViewModelState(
    val isProgressVisible: MutableStateFlow<Boolean> = MutableStateFlow(false),
    val recyclerSearchResults: MutableStateFlow<RecyclerComponent> = MutableStateFlow(RecyclerComponent()),
    val searchTermText: MutableStateFlow<String> = MutableStateFlow(""),
    val hasToShowBottomSheet: MutableStateFlow<Boolean> = MutableStateFlow(false),
    val isShowingResults: MutableStateFlow<Boolean> = MutableStateFlow(false),
    val isEmptyStateVisible: MutableStateFlow<Boolean> = MutableStateFlow(false),
    val resultsCount: MutableStateFlow<Int> = MutableStateFlow(0)
)