package com.miguelbrmfreitas.itunes_searcher.ui.main.adapter

import androidx.recyclerview.widget.DiffUtil
import com.miguelbrmfreitas.domain.entities.SearchResult

class SearchResultListDiffCallback(
    private val oldList: List<SearchResult>,
    private val newList: List<SearchResult>
) : DiffUtil.Callback()
{
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].trackId == newList[newItemPosition].trackId
    }

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return true
    }

}