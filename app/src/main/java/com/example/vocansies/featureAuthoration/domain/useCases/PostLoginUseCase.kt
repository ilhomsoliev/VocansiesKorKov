package com.example.vocansies.featureAuthoration.domain.useCases

import android.util.Log
import com.example.vocansies.core.entity.internal.Resource
import com.example.vocansies.featureAuthoration.data.remote.dto.LoginResponse
import com.example.vocansies.featureAuthoration.domain.repository.AuthorizationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PostLoginUseCase  @Inject constructor(
    private val repository: AuthorizationRepository
) {

    operator fun invoke(
        phone: String,
        password: String
    ): Flow<Resource<LoginResponse>> = flow {
        try {
            emit(Resource.Loading<LoginResponse>())
            val response = repository.postLogin(phone, password)
            emit(Resource.Success<LoginResponse>(response))
        } catch (e: HttpException) {
            emit(Resource.Error<LoginResponse>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<LoginResponse>("Couldn't reach server. Check your internet connection."))
        } catch (e:Exception){
            Log.d("Hello","${e.message} HEh")
            emit(Resource.Error<LoginResponse>("${e.message}"))
        }
    }
}