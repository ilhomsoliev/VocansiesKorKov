package com.example.vocansies.featureAuthoration.data.remote


import com.example.vocansies.featureAuthoration.data.remote.dto.LoginResponse
import com.example.vocansies.featureAuthoration.data.remote.dto.RegisterResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthorizationApi {

    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("phone") phone : String,
        @Field("password") password : String,
    ): LoginResponse

    @FormUrlEncoded
    @POST("register")
    suspend fun register1(
        @Field("city_id") city_id: Int,
        @Field("phone") phone: String,
    ): RegisterResponse
}