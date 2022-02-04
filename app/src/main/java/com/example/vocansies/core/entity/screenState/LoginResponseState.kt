package com.example.vocansies.core.entity.screenState

import com.example.vocansies.featureAuthoration.data.remote.dto.LoginResponse

data class LoginResponseState (
    val isLoading: Boolean = false,
    var response: LoginResponse? = null,
    val error: String = ""
)