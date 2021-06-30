package com.picpay.desafio.android.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val image: String,
    val name: String,
    val id: Int,
    val username: String
) : Parcelable