package com.example.vocansies.featureAuthoration.data.repository

import com.example.vocansies.featureAuthoration.data.remote.AuthorizationApi
import com.example.vocansies.featureAuthoration.data.remote.dto.LoginResponse
import com.example.vocansies.featureAuthoration.data.remote.dto.RegisterResponse
import com.example.vocansies.featureAuthoration.domain.repository.AuthorizationRepository

import javax.inject.Inject

class AuthorizationRepositoryImpl @Inject constructor(
    private val api: AuthorizationApi
) : AuthorizationRepository {
    override suspend fun postLogin(phone: String, password: String): LoginResponse =
        api.login(phone, password)

    override suspend fun postRegister(city_id: Int, phone: String): RegisterResponse =
        api.register1(city_id, phone)
}