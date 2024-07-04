package com.example.loveapp.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.loveapp.data.network.LoveResult

class LoveViewModel : ViewModel() {

    private val repository = LoveRepository()

    fun getLoveResult(firstName: String, secondName: String): LiveData<LoveResult> {
        return repository.getLoveResult(firstName, secondName)
    }
}