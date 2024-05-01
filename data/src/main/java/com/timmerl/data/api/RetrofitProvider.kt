package com.timmerl.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitProvider {
    fun getApi(): SportApi {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.thesportsdb.com/api/v1/json/50130162/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(SportApi::class.java)
    }
}
