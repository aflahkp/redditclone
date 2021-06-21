package com.clone.reddit.di.module

import com.clone.reddit.network.ApiServiceInterface
import com.clone.reddit.ui.feeds.base.Feeds
import com.clone.reddit.ui.feeds.presenter.FeedsPresenter
import dagger.Provides

class FeedsModule {

    @Provides
    fun provideListPresenter(): Feeds.Presenter {
        return FeedsPresenter()
    }

    @Provides
    fun provideApiService(): ApiServiceInterface {
        return ApiServiceInterface.create()
    }
}