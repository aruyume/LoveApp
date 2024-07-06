package com.example.loveapp.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.loveapp.data.network.LoveResult
import com.example.loveapp.mvvm.repository.LoveRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(
    private val repository: LoveRepository
) : ViewModel() {

    fun getLoveResult(firstName: String, secondName: String): LiveData<LoveResult> {
        return repository.getLoveResult(firstName, secondName)
    }
}