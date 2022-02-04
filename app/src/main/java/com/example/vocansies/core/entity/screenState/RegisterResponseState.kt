package com.example.vocansies.core.entity.screenState

import com.example.vocansies.featureAuthoration.data.remote.dto.LoginResponse
import com.example.vocansies.featureAuthoration.data.remote.dto.RegisterResponse

data class RegisterResponseState (
    val isLoading: Boolean = false,
    var response: RegisterResponse? = null,
    val error: String = ""
)