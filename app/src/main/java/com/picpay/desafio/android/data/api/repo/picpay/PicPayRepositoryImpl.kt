package com.picpay.desafio.android.data.api.repo.picpay

import com.picpay.desafio.android.data.api.PicPayService
import com.picpay.desafio.android.data.response.UserResponse

class PicPayRepositoryImpl(
    private val service : PicPayService
) : PicPayRepository {
    override suspend fun getUsers() : List<UserResponse> {
        return service.getUsers()
    }
}