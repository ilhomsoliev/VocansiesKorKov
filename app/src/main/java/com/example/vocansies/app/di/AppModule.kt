package com.example.vocansies.app.di

import com.example.vocansies.core.Constants
import com.example.vocansies.featureAuthoration.data.remote.AuthorizationApi
import com.example.vocansies.featureAuthoration.data.repository.AuthorizationRepositoryImpl
import com.example.vocansies.featureAuthoration.domain.repository.AuthorizationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideAuthorizationApi(): AuthorizationApi =
        Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL_AUTH)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthorizationApi::class.java)

    @Provides
    @Singleton
    fun provideAuthorizationRepository(api:AuthorizationApi): AuthorizationRepository =
        AuthorizationRepositoryImpl(api)

}