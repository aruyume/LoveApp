package com.example.loveapp

import android.app.Application
import com.example.loveapp.data.network.LoveApiService
import dagger.hilt.android.HiltAndroidApp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@HiltAndroidApp
class App: Application() {
}