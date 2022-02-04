package com.example.vocansies.featureAuthoration.domain.useCases

import android.util.Log
import com.example.vocansies.core.entity.internal.Resource
import com.example.vocansies.featureAuthoration.data.remote.dto.RegisterResponse
import com.example.vocansies.featureAuthoration.domain.repository.AuthorizationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PostRegisterUseCase @Inject constructor(
    private val repository: AuthorizationRepository
) {

    operator fun invoke(
        city_id: Int,
        phone: String
    ): Flow<Resource<RegisterResponse>> = flow {
        try {
            emit(Resource.Loading<RegisterResponse>())
            val response = repository.postRegister(city_id, phone)
            emit(Resource.Success<RegisterResponse>(response))
        } catch (e: HttpException) {
            emit(Resource.Error<RegisterResponse>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<RegisterResponse>("Couldn't reach server. Check your internet connection."))
        } catch (e:Exception){
            Log.d("Hello","${e.message} HEh")
            emit(Resource.Error<RegisterResponse>("${e.message}"))
        }
    }
}