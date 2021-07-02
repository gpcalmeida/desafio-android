package com.picpay.desafio.android.domain.usecases

import com.picpay.desafio.android.data.api.CacheRepository
import com.picpay.desafio.android.data.api.PicPayRepository
import com.picpay.desafio.android.domain.model.User

interface GetUserUseCase {
    suspend fun execute() : List<User>

    companion object {
        fun make(): GetUserUseCase {
            val repo = PicPayRepository.make()
            val cacheRepo = CacheRepository.make()
            return GetUserUseCaseImpl(repo, cacheRepo)
        }
    }
}