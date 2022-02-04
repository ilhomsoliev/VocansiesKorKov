package com.example.vocansies.featureAuthoration.presentation.registrationScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.vocansies.core.persistence.DataStore
import com.example.vocansies.featureAuthoration.domain.useCases.PostRegisterUseCase
import com.example.vocansies.core.entity.screenState.LoginResponseState
import com.example.vocansies.core.entity.screenState.RegisterResponseState
import com.example.vocansies.core.entity.screenState.TokenState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val postRegisterUseCase: PostRegisterUseCase,
    private val dataStore: DataStore
) : ViewModel() {
    private val _name = mutableStateOf("Ilhom")
    val name: State<String> = _name

    private val _phone = mutableStateOf("927266950")
    val phone: State<String> = _phone

    private val _password = mutableStateOf("password")
    val password: State<String> = _password

    private val _stateToken = mutableStateOf(TokenState())
    val stateToken: State<TokenState> = _stateToken

    private val _passwordVisibility = mutableStateOf(true)
    val passwordVisibility: State<Boolean> = _passwordVisibility

    private val _stateRegister = mutableStateOf(RegisterResponseState())
    val stateLogin: State<RegisterResponseState > = _stateRegister

    init{
        _stateRegister.value = RegisterResponseState(isLoading = false)
    }
    fun setName(name: String) {
        _name.value = name
    }

    fun setPasswordVisibility(passwordVisibility: Boolean) {
        _passwordVisibility.value = passwordVisibility
    }

    fun setPhone(phone: String) {
        _phone.value = phone
    }

    fun setPassword(password: String) {
        _password.value = password
    }

    fun register(
        phone: String,
        password: String
    ){

    }

}