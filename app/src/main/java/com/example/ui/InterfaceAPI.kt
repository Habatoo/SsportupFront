package com.example.ui

import retrofit2.Call
import retrofit2.http.GET

interface InterfaceAPI {
    @GET("/users/info")
    fun checkUserInfo(): Call<String?>?

    @GET("/events/info")
    fun checkEventInfo(): Call<String?>?
}