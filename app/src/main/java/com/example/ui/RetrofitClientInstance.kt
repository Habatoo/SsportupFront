package com.example.ui

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientInstance {
    private const val API_BASE_URL = "http://localhost/"
    private var retrofit: Retrofit? = null
    private var gson: Gson? = null
    val retrofitInstance: Retrofit?
        get() {
            if (retrofit == null) {
                gson = GsonBuilder()
                    .setLenient()
                    .create()
                retrofit = Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
            }
            return retrofit
        }
}