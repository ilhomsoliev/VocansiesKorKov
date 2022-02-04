package com.example.vocansies.featureAuthoration.data.remote.dto


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("access_token")
    var accessToken: String,
    @SerializedName("expires_at")
    var expiresAt: String,
    @SerializedName("token_type")
    var tokenType: String
)