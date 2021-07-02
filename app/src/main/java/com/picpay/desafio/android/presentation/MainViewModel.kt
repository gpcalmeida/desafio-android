package com.picpay.desafio.android.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.domain.model.result.MainResult
import com.picpay.desafio.android.domain.usecases.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val _mainState = MutableLiveData<MainResult>()
    var mainState : LiveData<MainResult> = _mainState

    fun getUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            _mainState.postValue(MainResult.Loading)
            try {
                val users = getUserUseCase.execute()
                _mainState.postValue(MainResult.Success(users))
            } catch(e: Exception) {
                _mainState.postValue(MainResult.Failure(e))
            }
        }
    }

}