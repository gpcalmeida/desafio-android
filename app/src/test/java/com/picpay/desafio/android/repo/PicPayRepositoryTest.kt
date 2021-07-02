package com.picpay.desafio.android.repo

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.picpay.desafio.android.data.api.repo.picpay.PicPayRepositoryImpl
import com.picpay.desafio.android.data.api.PicPayService
import com.picpay.desafio.android.data.response.UserResponse
import kotlinx.coroutines.runBlocking
import org.junit.Test

class PicPayRepositoryTest {

    private val api = mock<PicPayService>()

    private val repo = PicPayRepositoryImpl(api)

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