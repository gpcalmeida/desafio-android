package com.picpay.desafio.android.data.api

import com.picpay.desafio.android.data.response.UserResponse
import com.picpay.desafio.android.data.room.UserDatabase
import com.picpay.desafio.android.injection.DependencyProvider

class CacheRepository(
    private val userDatabase: UserDatabase
) : DataRepository {
    override suspend fun getUsers(): List<UserResponse> {
        return userDatabase.userDao().getUsers()
    }

    fun cacheUsers(users: List<UserResponse>) {
        userDatabase.userDao().insertUser(users)
    }

    companion object {
        fun make() : CacheRepository {
            return CacheRepository(DependencyProvider.userDatabase)
        }
    }
}