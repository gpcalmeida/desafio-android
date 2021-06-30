package com.picpay.desafio.android.domain.usecases

import com.picpay.desafio.android.data.api.CacheRepository
import com.picpay.desafio.android.data.api.PicPayRepository
import com.picpay.desafio.android.domain.mappers.mapToUser
import com.picpay.desafio.android.domain.model.User

class GetUserUseCase(
    private val apiRepository: PicPayRepository,
    private val cacheRepository: CacheRepository
) {
    suspend fun execute(): List<User> {
        val cachedData = cacheRepository.getUsers()
        return (if (cachedData.isEmpty()) {
            val users = apiRepository.getUsers()
            cacheRepository.cacheUsers(users)
            users
        } else {
            cachedData
        }).map { it.mapToUser() }
    }

    companion object {
        fun make(): GetUserUseCase {
            val repo = PicPayRepository.make()
            val cacheRepo = CacheRepository.make()
            return GetUserUseCase(repo, cacheRepo)
        }
    }
}

