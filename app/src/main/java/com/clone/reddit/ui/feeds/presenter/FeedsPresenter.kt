package com.clone.reddit.ui.feeds.presenter

import com.bumptech.glide.Glide
import com.clone.reddit.network.ApiServiceInterface
import com.clone.reddit.ui.feeds.adapter.FeedAdapter
import com.clone.reddit.ui.feeds.base.Feeds
import com.clone.reddit.ui.feeds.model.FeedItemModel
import com.clone.reddit.ui.feeds.view.FeedItemView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FeedsPresenter: Feeds.Presenter {

    private val api: ApiServiceInterface = ApiServiceInterface.create()
    var feedItems: MutableList<FeedItemModel.Post> = arrayListOf();
    private lateinit var feedsAdapter: FeedAdapter



    fun setAdapter(adapter:FeedAdapter){
        this.feedsAdapter = adapter;
    }

    fun getAdapter(): FeedAdapter{
        return this.feedsAdapter;
    }


    companion object {
        fun getPresenter(): FeedsPresenter
        {
            val presenter = FeedsPresenter();
            val adapter = FeedAdapter(presenter);
            presenter.setAdapter(adapter)

            return presenter;
        }
    }

    fun getFeedsItemCount(): Int {
        return feedItems.count()
    }

    fun onBindFeedItemViewAtPosition(position: Int, feedItemView: FeedItemView){
        val feedItem = feedItems[position];
        feedItem.data.title?.let { feedItemView.setTitle(it) }
        feedItem.data.author?.let { feedItemView.setAuthor(it) }
        feedItem.data.subreddit_name_prefixed?.let { feedItemView.setMessage(it) }
        feedItemView.setThumbnail(feedItem.data.thumbnail?:"")
    }

    private fun appendFeedItemsData(items: List<FeedItemModel.Post>){
        this.feedItems.addAll(items)
    }

    fun loadData() {
        api.getFeeds().enqueue(object : Callback<FeedItemModel.FeedsResponse>{
            override fun onFailure(call: Call<FeedItemModel.FeedsResponse>, t: Throwable) {
                System.out.println("Failed")
            }

            override fun onResponse(call: Call<FeedItemModel.FeedsResponse>, response: Response<FeedItemModel.FeedsResponse>) {
                appendFeedItemsData(response.body()?.data?.children!!)
                feedsAdapter.notifyDataSetChanged()
            }

        })
    }
}