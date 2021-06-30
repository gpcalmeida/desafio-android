package com.picpay.desafio.android.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.domain.model.User
import com.picpay.desafio.android.domain.usecases.GetUserUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val _users = MutableLiveData<List<User>>()
    var users : LiveData<List<User>> = _users

    fun getUsers() {
        viewModelScope.launch {
            _users.postValue(getUserUseCase.execute())
        }
    }

}