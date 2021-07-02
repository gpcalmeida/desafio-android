package com.picpay.desafio.android.injection

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.picpay.desafio.android.data.api.PicPayService
import com.picpay.desafio.android.data.room.UserDatabase
import com.picpay.desafio.android.domain.mappers.mapToUser
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object DependencyProvider {

    private const val API_URL = "https://609a908e0f5a13001721b74e.mockapi.io/picpay/api/"
    private val gson: Gson = GsonBuilder().create()
    private val okHttp: OkHttpClient =
        OkHttpClient.Builder()
            .build()

    private val picPayRetrofitInstance: Retrofit = Retrofit.Builder()
        .baseUrl(API_URL)
        .client(okHttp)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val picPayService: PicPayService = picPayRetrofitInstance.create(PicPayService::class.java)
    val userDatabase = UserDatabase.getDatabase()
}
