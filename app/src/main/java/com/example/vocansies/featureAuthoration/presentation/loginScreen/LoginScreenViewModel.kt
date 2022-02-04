package com.example.vocansies.featureAuthoration.presentation.loginScreen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vocansies.core.entity.internal.Resource
import com.example.vocansies.core.persistence.DataStore
import com.example.vocansies.featureAuthoration.data.remote.dto.LoginResponse
import com.example.vocansies.featureAuthoration.domain.useCases.PostLoginUseCase
import com.example.vocansies.core.entity.screenState.LoginResponseState
import com.example.vocansies.core.entity.screenState.TokenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val postLoginUseCase: PostLoginUseCase,
    private val dataStore: DataStore
) : ViewModel() {

    private val _stateLogin = mutableStateOf(LoginResponseState())
    val stateLogin: State<LoginResponseState> = _stateLogin

    private val _stateToken = mutableStateOf(TokenState())
    val stateToken: State<TokenState> = _stateToken

    private val _phone = mutableStateOf("927266950")
    val phone: State<String> = _phone

    private val _password = mutableStateOf("password")
    val password: State<String> = _password

    private val _passwordVisibility = mutableStateOf(true)
    val passwordVisibility: State<Boolean> = _passwordVisibility

    fun setPhone(phone: String) {
        _phone.value = phone
    }

    fun setPassword(password: String) {
        _password.value = password
    }

    fun setPasswordVisibility(passwordVisibility: Boolean) {
        _passwordVisibility.value = passwordVisibility
    }

    fun makeTokenEmpty() {
        _stateToken.value = _stateToken.value.copy(isLoading = true, tokenResponse = "")
    }

    init {
        _stateToken.value = _stateToken.value.copy(isLoading = true)
        getTokenFromLocal()
    }

    fun login(
        phone: String,
        password: String
    ) {
        postLoginUseCase(phone, password).onEach { result: Resource<LoginResponse> ->
            when (result) {
                is Resource.Success -> {
                    Log.d("Hello", "${result.data?.accessToken} responseLogin")
                    val accessToken = result.data?.accessToken!!
                    dataStore.storeUserToken(accessToken)
                    _stateLogin.value = LoginResponseState(response = result.data)
                }
                is Resource.Error -> {
                    _stateLogin.value = LoginResponseState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _stateLogin.value = LoginResponseState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getTokenFromLocal() {
        dataStore.userTokenFlow.onEach { result: String ->
            _stateToken.value = _stateToken.value.copy(isLoading = false, tokenResponse = result)
            Log.d("Hello", "$result Token")
        }.launchIn(viewModelScope)
    }
}