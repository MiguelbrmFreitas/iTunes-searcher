package com.miguelbrmfreitas.itunes_searcher.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.miguelbrmfreitas.domain.entities.SearchResult
import com.miguelbrmfreitas.itunes_searcher.R
import com.miguelbrmfreitas.itunes_searcher.databinding.ItemSearchResultBinding

class SearchResultAdapter : RecyclerView.Adapter<SearchResultViewHolder>()
{
    var searchResultList = emptyList<SearchResult>()
        set(value) {
            val diff = DiffUtil.calculateDiff(
                SearchResultListDiffCallback(field, value)
            )
            diff.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultViewHolder {
        val view = DataBindingUtil.inflate<ItemSearchResultBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_search_result,
            parent,
            false
        )

        return SearchResultViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchResultViewHolder, position: Int) {
        holder.bind(searchResultList[position])
    }

    override fun getItemCount(): Int = searchResultList.size

}