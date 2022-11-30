package com.contoh.mvckotlin.network

import com.contoh.mvckotlin.model.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    //    https://jsonplaceholder.typicode.com/todos/1
    @GET("todos/1")
    fun getDOTOData(): Call<User>

}