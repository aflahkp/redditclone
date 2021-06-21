package com.clone.reddit.ui.login.model

import com.google.gson.annotations.SerializedName


class LoginResponse {
    data class Response(@SerializedName("json") val json: Json)
    data class Json(@SerializedName("data") val data: Data)
    data class Data(@SerializedName("modhash") val modhash: String,@SerializedName("cookie")  val cookie: String)
}