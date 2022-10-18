package com.miguelbrmfreitas.itunes_searcher.ui.util.components

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView

data class RecyclerComponent(
    val adapter: RecyclerView.Adapter<*>? = null,
    val layoutManager: LinearLayoutManager? = null,
    val snapOneByOne: LinearSnapHelper? = null,
    val canScrollVertically: Boolean = false,
    val onScrollListener: RecyclerView.OnScrollListener? = null
){
    private var view: RecyclerView? = null

    fun setRecyclerView(view: RecyclerView?){
        this.view = view
    }
}