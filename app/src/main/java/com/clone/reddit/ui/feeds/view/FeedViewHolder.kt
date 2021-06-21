package com.clone.reddit.ui.feeds.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.clone.reddit.R

class FeedViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),
    FeedItemView {

    private var titleTextView:TextView = itemView.findViewById(R.id.titleTextView)
    private var subRedditTextView:TextView = itemView.findViewById(R.id.subRedditTextView)
    private var messageTextView: TextView = itemView.findViewById(R.id.messageTextView)
    private var postImageView: ImageView = itemView.findViewById(R.id.postImage)
    private var authorImageView: ImageView = itemView.findViewById(R.id.authorImage)


    override fun setTitle(title: String) {
        titleTextView.text = title;
    }

    override fun setMessage(message: String) {
        subRedditTextView.text = message;
    }


    override fun setAuthor(author: String) {
        messageTextView.text = author;
    }

    override fun setThumbnail(imageUrl: String) {
        if(imageUrl == "self" || imageUrl == "default") {
            postImageView.visibility = View.GONE

            Glide.with(authorImageView)
                .load(R.drawable.reddit_placeholder)
                .into(authorImageView)
        }
        else if(!imageUrl?.trim().isNullOrBlank()) {
            postImageView.visibility = View.VISIBLE
            Glide.with(postImageView)
                .load(imageUrl)
                .centerCrop()
                .into(postImageView)

            Glide.with(authorImageView)
                .load(imageUrl)
                .circleCrop()
                .placeholder(R.drawable.reddit_placeholder)
                .into(authorImageView)
        }
    }


}
