package com.example.booksearchapp.ui.adapter

import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.example.booksearchapp.databinding.ItemLoadStateBinding

class BookSearchLoadStateViewHolder(
    private val bindig: ItemLoadStateBinding,
    retry: () -> Unit
) : RecyclerView.ViewHolder(bindig.root) {

    init {
        bindig.btnRetry.setOnClickListener {
            retry.invoke()
        }
    }

    fun bind(loadState: LoadState) {
        if (loadState is LoadState.Error) {
            bindig.tvError.text = "Error occurred"
        }
        bindig.progressBar.isVisible = loadState is LoadState.Loading
        bindig.btnRetry.isVisible = loadState is LoadState.Error
        bindig.tvError.isVisible = loadState is LoadState.Error
    }
}