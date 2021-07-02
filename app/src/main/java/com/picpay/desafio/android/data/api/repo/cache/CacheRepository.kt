package com.picpay.desafio.android.data.api.repo.cache

import com.picpay.desafio.android.data.api.repo.DataRepository
import com.picpay.desafio.android.data.response.UserResponse
import com.picpay.desafio.android.injection.DependencyProvider

interface CacheRepository : DataRepository {
    fun cacheUsers(users : List<UserResponse>)

    companion object {
        fun make() : CacheRepository {
            return CacheRepositoryImpl(DependencyProvider.userDatabase)
        }
    }
}