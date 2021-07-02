package com.picpay.desafio.android.data.api.repo.cache

import com.picpay.desafio.android.data.api.repo.cache.CacheRepository
import com.picpay.desafio.android.data.response.UserResponse
import com.picpay.desafio.android.data.room.UserDatabase

class CacheRepositoryImpl(
    private val userDatabase: UserDatabase
) : CacheRepository {
    override suspend fun getUsers(): List<UserResponse> {
        return userDatabase.userDao().getUsers()
    }

    override fun cacheUsers(users: List<UserResponse>) {
        userDatabase.userDao().insertUser(users)
    }
}