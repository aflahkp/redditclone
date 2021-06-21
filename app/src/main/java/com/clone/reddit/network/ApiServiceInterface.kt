package com.clone.reddit.network

import com.clone.reddit.ui.feeds.model.FeedItemModel
import com.clone.reddit.ui.login.model.LoginResponse
import com.clone.reddit.util.Constants
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

import java.util.*

interface ApiServiceInterface {



    @POST("api/login/Distinct_Bag9762?user=Distinct_Bag9762&passwd=tempme@red&api_type=json")
    fun login(): Call<LoginResponse.Response>


    @GET(".json")
    fun getFeeds(): Call<FeedItemModel.FeedsResponse>

    @GET("r/{subreddit}/.json")
    fun getSubReddit(@Path("subreddit") subreddit: String): List<FeedItemModel.FeedsResponse>

    companion object Factory {
        fun create(): ApiServiceInterface {
            val retrofit = retrofit2.Retrofit.Builder()
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build()

            return retrofit.create(ApiServiceInterface::class.java)
        }
    }
}