package com.example.vocansies.featureAuthoration.domain.repository

import com.example.vocansies.featureAuthoration.data.remote.dto.LoginResponse
import com.example.vocansies.featureAuthoration.data.remote.dto.RegisterResponse


interface AuthorizationRepository {

    suspend fun postLogin(phone: String, password: String) : LoginResponse

    suspend fun postRegister(city_id: Int, phone: String): RegisterResponse

}