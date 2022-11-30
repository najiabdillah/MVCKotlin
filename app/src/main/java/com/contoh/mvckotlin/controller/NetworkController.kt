package com.contoh.mvckotlin.controller

import com.contoh.mvckotlin.network.ApiService
import com.contoh.mvckotlin.model.User
import com.contoh.mvckotlin.util.CustomCallback
import com.contoh.mvckotlin.network.NetworkUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkController() {

    fun getResponse(customCallback : CustomCallback) {

        var apiclass = NetworkUtil().getRetrofit().create(ApiService::class.java)

        var users = apiclass.getDOTOData()

        users.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {

                var myResponse = response.body()
                var title : String = myResponse.title

                customCallback.onSuccessResponse(title)
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                customCallback.onFailureResponse()
            }
        })
    }
}