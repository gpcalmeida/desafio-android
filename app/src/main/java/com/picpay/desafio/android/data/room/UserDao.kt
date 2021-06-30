package com.picpay.desafio.android.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.picpay.desafio.android.data.response.UserResponse
import com.picpay.desafio.android.domain.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table")
    fun getUsers() : List<UserResponse>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(users : List<UserResponse>)
}