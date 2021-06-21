package com.clone.reddit.ui.feeds.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.clone.reddit.R
import com.clone.reddit.ui.feeds.presenter.FeedsPresenter
import com.clone.reddit.ui.feeds.view.FeedViewHolder

class FeedAdapter(private val feedsPresenter: FeedsPresenter): RecyclerView.Adapter<FeedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        return FeedViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(R.layout.feed_recylerview_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return feedsPresenter.getFeedsItemCount()
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        feedsPresenter.onBindFeedItemViewAtPosition(position, holder)
    }
}