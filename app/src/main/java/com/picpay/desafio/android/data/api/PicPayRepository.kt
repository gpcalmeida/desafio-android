package com.picpay.desafio.android.data.api

import com.picpay.desafio.android.data.response.UserResponse
import com.picpay.desafio.android.data.room.UserDao
import com.picpay.desafio.android.data.room.UserDatabase
import com.picpay.desafio.android.domain.mappers.mapToUser
import com.picpay.desafio.android.injection.DependencyProvider

class PicPayRepository(
    private val service : PicPayService
) : DataRepository {
    override suspend fun getUsers() : List<UserResponse> {
        return service.getUsers()
    }

    companion object {
        fun make() : PicPayRepository {
            return PicPayRepository(DependencyProvider.picPayService)
        }
    }
}