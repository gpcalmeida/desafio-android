package com.picpay.desafio.android.injection

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.picpay.desafio.android.domain.usecases.GetUserUseCase
import com.picpay.desafio.android.presentation.MainViewModel

object MainInjection {

    private class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            val getUserUseCase = GetUserUseCase.make()
            val viewModel = MainViewModel(getUserUseCase)
            return viewModel as T
        }
    }

    fun AppCompatActivity.injectMainViewModel(): MainViewModel {
        return ViewModelProvider(this, MainInjection.Factory()).get(MainViewModel::class.java)
    }
}