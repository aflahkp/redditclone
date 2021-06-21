package com.clone.reddit.ui.feeds.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.clone.reddit.R
import com.clone.reddit.ui.feeds.adapter.FeedAdapter
import com.clone.reddit.ui.feeds.base.Feeds
import com.clone.reddit.ui.feeds.model.FeedItemModel
import com.clone.reddit.ui.feeds.presenter.FeedsPresenter

class FeedsFragment() : Fragment(), Feeds.Presenter{

    val feedsPresenter = FeedsPresenter.getPresenter();

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val recyclerView: RecyclerView = root.findViewById(R.id.feedRecyclerView)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = feedsPresenter.getAdapter();
        return root
    }
    private fun initView() {
        feedsPresenter.loadData();
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

}
