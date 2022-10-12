package com.miguelbrmfreitas.itunes_searcher.di

import com.miguelbrmfreitas.data.di.createGetResultsUseCase
import com.miguelbrmfreitas.data.di.createItunesRepository
import com.miguelbrmfreitas.itunes_searcher.ui.main.viewmodel.MainViewModel
import com.miguelbrmfreitas.itunes_searcher.ui.main.viewmodel.MainViewModelState
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { MainViewModel(get(), get()) }

    factory { MainViewModelState() }

    single { createItunesRepository(get()) }

    single { createGetResultsUseCase(get()) }
}