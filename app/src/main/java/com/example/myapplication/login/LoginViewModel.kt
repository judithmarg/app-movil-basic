package com.example.myapplication.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    val state : LiveData<LoginState>
        get() = _state

    sealed class LoginState {
        object Loading: LoginState()
        object LoggedOut: LoginState()
        data class DoLogin(val message: String): LoginState()
        data class Error(val message: String): LoginState()
    }

    private var _state = MutableLiveData<LoginState>()

    fun doLogin(userName: String, password: String) {
        _state.value = LoginState.Loading
        if(userName == "calyr") {
            _state.value = LoginState.DoLogin("Success")
        } else {
            _state.value = LoginState.Error("Invalid credential")
        }
    }
}