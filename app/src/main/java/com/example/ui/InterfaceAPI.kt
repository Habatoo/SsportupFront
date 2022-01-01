package com.example.ui

import retrofit2.Call
import retrofit2.http.GET

interface InterfaceAPI {
    //@GET("/users/info")
    @GET
    fun checkUserInfo(): Call<String?>?

    @GET("/events/info")
    fun checkEventInfo(): Call<String?>?
}