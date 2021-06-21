package com.clone.reddit.ui.feeds.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.clone.reddit.R

class FeedViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),
    FeedItemView {

    private var titleTextView:TextView = itemView.findViewById(R.id.titleTextView)
    private var messageTextView: TextView = itemView.findViewById(R.id.messageTextView)


    override fun setTitle(title: String) {
        titleTextView.text = title;
    }

    override fun setMessage(message: String) {
        messageTextView.text = message;
    }

}
