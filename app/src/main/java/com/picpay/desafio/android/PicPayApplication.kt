package com.picpay.desafio.android

import android.app.Application
import com.picpay.desafio.android.data.room.UserDatabase

class PicPayApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        UserDatabase.getDatabase(this.applicationContext)
    }
}