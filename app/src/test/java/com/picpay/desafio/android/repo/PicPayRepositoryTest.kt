package com.picpay.desafio.android.repo

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.picpay.desafio.android.data.api.PicPayRepository
import com.picpay.desafio.android.data.api.PicPayService
import com.picpay.desafio.android.data.response.UserResponse
import com.picpay.desafio.android.domain.model.User
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test
import retrofit2.Call
import retrofit2.Response

class PicPayRepositoryTest {

    private val api = mock<PicPayService>()

    private val repo = PicPayRepository(api)

    @Test
    fun `test repo`() {
        runBlocking {
            val list = mock<List<UserResponse>>()
            whenever(api.getUsers()).thenReturn(list)
            repo.getUsers()
            verify(api.getUsers())
        }
    }
}