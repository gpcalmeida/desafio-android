package com.picpay.desafio.android.domain.mappers

import com.picpay.desafio.android.data.response.UserResponse
import com.picpay.desafio.android.domain.model.User

fun UserResponse.mapToUser() : User =
    User(
        id = id ?: -1,
        name = name ?: "",
        image = img ?: "",
        username = username ?: ""
    )