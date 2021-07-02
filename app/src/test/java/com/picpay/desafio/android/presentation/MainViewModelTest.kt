package com.picpay.desafio.android.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.*
import com.picpay.desafio.android.domain.model.User
import com.picpay.desafio.android.domain.model.result.MainResult
import com.picpay.desafio.android.domain.usecases.GetUserUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    @get:Rule
    var rule = InstantTaskExecutorRule()

    private val mainObserver = mock<Observer<MainResult>>()
    private val getUserUseCase = mock<GetUserUseCase>()
    private val mainViewModel = MainViewModel(getUserUseCase)

    private val user = User("","", -1, "")

    @Test
    fun `getUsers Success`() {
        runBlocking {
            whenever(getUserUseCase.execute()).thenReturn(listOf(user))
            mainViewModel.mainState.observeForever(mainObserver)

            mainViewModel.getUsers()

            verify(mainObserver, after(200)).onChanged(MainResult.Loading)
            verify(mainObserver).onChanged(MainResult.Success(listOf(user)))
        }
    }
}