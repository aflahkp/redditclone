package com.clone.reddit.ui.login.presenter

import com.clone.reddit.network.ApiServiceInterface
import com.clone.reddit.ui.login.model.LoginResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter {
    private val api: ApiServiceInterface = ApiServiceInterface.create()

    companion object{
        fun getPresenter(): LoginPresenter{
            return LoginPresenter()
        }
    }

    suspend fun login(storeString: suspend(key: String, value: String) -> Unit, onSuccess: () -> Unit){
        api.login().enqueue(object: Callback<LoginResponse.Response>{
            override fun onFailure(call: Call<LoginResponse.Response>, t: Throwable) {
                System.out.println(t)
            }

            override fun onResponse(call: Call<LoginResponse.Response>, response: Response<LoginResponse.Response>) {
            CoroutineScope(Default).launch {
                withContext(Default) {storeString("cookie", response.body()!!.json.data.cookie)}
                withContext(Default) {storeString("modhash", response.body()!!.json.data.modhash)}
                onSuccess()
                }
                //TODO  to be implemented without using lambdas
            }

        })
    }

}