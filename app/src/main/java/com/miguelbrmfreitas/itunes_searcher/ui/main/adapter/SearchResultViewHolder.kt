package com.miguelbrmfreitas.itunes_searcher.ui.main.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import coil.load
import com.miguelbrmfreitas.domain.entities.SearchResult
import com.miguelbrmfreitas.itunes_searcher.R
import com.miguelbrmfreitas.itunes_searcher.databinding.ItemSearchResultBinding

class SearchResultViewHolder (
    val view: ItemSearchResultBinding
) : RecyclerView.ViewHolder(view.root)
{
    fun bind(searchResult: SearchResult) {
        view.apply {
            artistName = searchResult.artistName
            trackName = searchResult.trackName

            ivCover.load(searchResult.imageCoverUrl) {
                placeholder(createCircularProgressDrawable(root.context))
                error(R.drawable.ic_song_placeholder)
            }
        }
    }

    private fun createCircularProgressDrawable(context: Context): CircularProgressDrawable {
        val circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        return circularProgressDrawable
    }
}