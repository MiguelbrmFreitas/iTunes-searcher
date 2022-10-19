package com.miguelbrmfreitas.itunes_searcher.ui.main.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import coil.load
import com.miguelbrmfreitas.domain.entities.SearchResult
import com.miguelbrmfreitas.itunes_searcher.R
import com.miguelbrmfreitas.itunes_searcher.databinding.ItemSearchResultBinding
import com.miguelbrmfreitas.itunes_searcher.ui.main.listeners.IResultClickListener
import com.miguelbrmfreitas.itunes_searcher.ui.util.extensions.createCircularProgressDrawable

class SearchResultViewHolder (
    val view: ItemSearchResultBinding,
    private val clickListener: IResultClickListener
) : RecyclerView.ViewHolder(view.root)
{
    fun bind(searchResult: SearchResult) {

        view.apply {
            val context = root.context
            val circularProgressDrawable = context.createCircularProgressDrawable()

            artistName = searchResult.artistName
            trackName = searchResult.trackName

            ivCover.load(searchResult.imageCoverUrl) {
                placeholder(circularProgressDrawable)
                error(R.drawable.ic_song_placeholder)
            }

            itemView.setOnClickListener {
                clickListener.onResultClicked(searchResult)
            }
        }
    }
}