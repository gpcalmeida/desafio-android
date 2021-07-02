package com.picpay.desafio.android.mapper

import com.picpay.desafio.android.data.response.UserResponse
import com.picpay.desafio.android.domain.mappers.mapToUser
import com.picpay.desafio.android.domain.model.User
import org.junit.Test

class UserMapperTest {

    @Test
    fun `should convert to User from UserResponse`() {
        val userResponse = UserResponse(
            id = -1,
            name = "Gustavo",
            img = "url here",
            username = "almeida"
        )

        val user = userResponse.mapToUser()

        assert(
            user == User(
                userResponse.img ?: "",
                userResponse.name ?: "",
                userResponse.id ?: -1,
                userResponse.username ?: ""
            )
        )
    }
}