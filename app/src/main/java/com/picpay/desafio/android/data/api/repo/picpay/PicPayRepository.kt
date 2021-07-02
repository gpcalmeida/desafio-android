package com.picpay.desafio.android.data.api.repo.picpay

import com.picpay.desafio.android.data.api.repo.DataRepository
import com.picpay.desafio.android.injection.DependencyProvider

interface PicPayRepository : DataRepository {
    companion object {
        fun make() : PicPayRepository {
            return PicPayRepositoryImpl(DependencyProvider.picPayService)
        }
    }
}