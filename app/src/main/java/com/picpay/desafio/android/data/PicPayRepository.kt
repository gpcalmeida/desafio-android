package com.picpay.desafio.android.data

import com.picpay.desafio.android.data.response.UserResponse
import com.picpay.desafio.android.domain.model.User
import com.picpay.desafio.android.injection.DependencyProvider

class PicPayRepository(
    private val service : PicPayService
) {
    suspend fun getUsers() : List<UserResponse> {
        return service.getUsers()
    }

    companion object {
        fun make() : PicPayRepository {
            return PicPayRepository(DependencyProvider.picPayService)
        }
    }
}