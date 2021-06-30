package com.picpay.desafio.android.domain.usecases

import com.picpay.desafio.android.data.PicPayRepository
import com.picpay.desafio.android.domain.model.User

class GetUserUseCase(
    private val repository: PicPayRepository
) {

    suspend fun execute() : List<User> = repository.getUsers()
}