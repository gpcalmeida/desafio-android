package com.picpay.desafio.android.domain.usecases

import com.picpay.desafio.android.data.PicPayRepository
import com.picpay.desafio.android.domain.mappers.mapToUser
import com.picpay.desafio.android.domain.model.User

class GetUserUseCase(
    private val repository: PicPayRepository
) {
    suspend fun execute() : List<User> = repository.getUsers().map { it.mapToUser() }

    companion object {
        fun make() : GetUserUseCase {
            val repo = PicPayRepository.make()
            return GetUserUseCase(repo)
        }
    }
}