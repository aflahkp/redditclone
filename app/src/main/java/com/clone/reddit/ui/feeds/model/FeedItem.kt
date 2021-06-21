package com.clone.reddit.ui.feeds.model

import com.google.gson.annotations.SerializedName


class FeedItemModel {
    data class FeedsResponse(
        @SerializedName("data") val data: ResponseData,
        @SerializedName("kind") val kind: String);

    data class ResponseData(
        @SerializedName("modhash")  val modhash: String,
        @SerializedName("dist") val dist: Int,
        @SerializedName("children") val children: List<Post>
    );
    data class Post(
        @SerializedName("kind") val kind: String,
        @SerializedName("data") val data: PostData
    );
    data class PostData(
        @SerializedName("subreddit") val subreddit: String,
        @SerializedName("title") val title: String?,
        @SerializedName("author") val author: String?,
        @SerializedName("subreddit_name_prefixed") val subreddit_name_prefixed: String?,
        @SerializedName("thumbnail") val thumbnail: String?,
        @SerializedName("author_fullname") val author_fullname: String?
    );

}
