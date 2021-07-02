package com.picpay.desafio.android.data.api.repo

import com.picpay.desafio.android.data.response.UserResponse

interface DataRepository {
    suspend fun getUsers() : List<UserResponse>
}