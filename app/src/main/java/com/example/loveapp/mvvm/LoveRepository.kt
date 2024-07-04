package com.example.loveapp.mvvm

import androidx.lifecycle.MutableLiveData
import com.example.loveapp.data.network.LoveResult
import com.example.loveapp.data.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoveRepository {
    private val api = RetrofitService.api
    private var loveResults = MutableLiveData<LoveResult>()

    fun getLoveResult(firstName: String, secondName: String): MutableLiveData<LoveResult> {
        api.getPercentage(
            firstName = firstName,
            secondName = secondName
        ).enqueue(object :
            Callback<LoveResult> {
            override fun onResponse(
                call: Call<LoveResult>,
                response: Response<LoveResult>
            ) {
                loveResults.value = response.body()
            }
            override fun onFailure(call: Call<LoveResult>, t: Throwable) {
                t.printStackTrace()
            }
        })
        return loveResults
    }
}