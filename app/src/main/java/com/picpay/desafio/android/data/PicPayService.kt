package com.picpay.desafio.android.data

import com.picpay.desafio.android.domain.User
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET


interface PicPayService {

    @GET("users")
    suspend fun getUsers(): List<User>
}