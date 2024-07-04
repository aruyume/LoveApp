package com.example.loveapp.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    private var retrofit = Retrofit.Builder()
        .baseUrl("https://love-calculator.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val api = retrofit.create(LoveApiService::class.java)
}