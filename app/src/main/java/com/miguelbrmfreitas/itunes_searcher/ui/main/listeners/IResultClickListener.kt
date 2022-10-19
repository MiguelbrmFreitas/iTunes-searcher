package com.miguelbrmfreitas.itunes_searcher.ui.main.listeners

import com.miguelbrmfreitas.domain.entities.SearchResult

interface IResultClickListener
{
    fun onResultClicked(searchResult: SearchResult)
}