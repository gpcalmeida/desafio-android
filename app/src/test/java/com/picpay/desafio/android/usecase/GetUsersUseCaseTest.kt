package com.picpay.desafio.android.usecase

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.picpay.desafio.android.data.api.repo.DataRepository
import com.picpay.desafio.android.data.api.repo.cache.CacheRepository
import com.picpay.desafio.android.data.api.repo.picpay.PicPayRepository
import com.picpay.desafio.android.domain.model.User
import com.picpay.desafio.android.domain.usecases.GetUserUseCaseImpl
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetUsersUseCaseTest {

    private val repository = mock<PicPayRepository>()
    private val cacheRepository = mock<CacheRepository>()
    private val getUserUseCase = GetUserUseCaseImpl(repository, cacheRepository)

    @Test
    fun `test get users execute`() {
        runBlocking {
            whenever(repository.getUsers()).thenAnswer { emptyList<User>()  }
            whenever(cacheRepository.getUsers()).thenAnswer { emptyList<User>() }
            getUserUseCase.execute()
            verify(repository).getUsers()
            verify(cacheRepository).getUsers()
        }
    }
}