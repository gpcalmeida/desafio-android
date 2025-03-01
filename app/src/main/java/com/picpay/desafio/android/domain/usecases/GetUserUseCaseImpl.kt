package com.picpay.desafio.android.domain.usecases

import com.picpay.desafio.android.data.api.repo.cache.CacheRepository
import com.picpay.desafio.android.data.api.repo.picpay.PicPayRepository
import com.picpay.desafio.android.domain.mappers.mapToUser
import com.picpay.desafio.android.domain.model.User

class GetUserUseCaseImpl(
    private val apiRepository: PicPayRepository,
    private val cacheRepository: CacheRepository
) : GetUserUseCase {
    override suspend fun execute(): List<User> {
        val cachedData = cacheRepository.getUsers()
        return (if (cachedData.isEmpty()) {
            val users = apiRepository.getUsers()
            cacheRepository.cacheUsers(users)
            users
        } else {
            cachedData
        }).map { it.mapToUser() }
    }
}

