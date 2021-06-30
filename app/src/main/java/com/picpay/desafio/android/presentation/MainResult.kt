package com.picpay.desafio.android.presentation

import com.picpay.desafio.android.domain.model.User

sealed class MainResult {
    data class Success(val users: List<User>) : MainResult()
    data class Failure(val throwable: Throwable) : MainResult()
    object Loading : MainResult()

}