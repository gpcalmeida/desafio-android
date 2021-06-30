package com.picpay.desafio.android.data

import com.picpay.desafio.android.domain.model.User

class PicPayRepository(
    private val service : PicPayService
) {
    suspend fun getUsers() : List<User> {
        return service.getUsers()
    }
}