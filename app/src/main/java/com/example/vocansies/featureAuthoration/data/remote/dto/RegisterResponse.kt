package com.example.vocansies.featureAuthoration.data.remote.dto


import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("driver_id")
    var driverId: Int,
    @SerializedName("message")
    var message: String
)