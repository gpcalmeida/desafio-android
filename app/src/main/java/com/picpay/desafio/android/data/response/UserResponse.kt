package com.picpay.desafio.android.data.response

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user_table")
data class UserResponse(
    @SerializedName("img") val img: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("id") @PrimaryKey val id: Int?,
    @SerializedName("username") val username: String?
)