package com.example.loveapp.mvp

import com.example.loveapp.data.network.LoveResult

interface LoveContract {
    interface View {
        fun showProgress()
        fun hideProgress()
        fun showResult(loveResult: LoveResult)
        fun showError(error: String)
    }

    interface Model {
        fun getLovePercentage(
            firstName: String,
            secondName: String,
            callback: (result: LoveResult?, error: String?) -> Unit
        )
    }

    interface Presenter {
        fun calculateLovePercentage(firstName: String, secondName: String)
    }
}