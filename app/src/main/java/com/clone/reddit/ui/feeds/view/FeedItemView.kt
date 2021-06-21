package com.clone.reddit.ui.feeds.view

interface FeedItemView {
    fun setTitle(title: String);
    fun setMessage(message: String);
    fun setThumbnail(imageUrl: String);
    fun setAuthor(imageUrl: String)
}