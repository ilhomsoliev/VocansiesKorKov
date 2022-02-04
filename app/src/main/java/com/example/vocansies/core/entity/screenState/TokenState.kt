package com.example.vocansies.core.entity.screenState


data class TokenState (
    var isLoading: Boolean = true,
    var tokenResponse: String = "",
    val error: String = ""
)