package com.loodos.cryptoapp.services.repository

import com.loodos.cryptoapp.services.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class BaseRepository {

    private val baseUrl = "https://api.coingecko.com"


    fun <T> buildApi(api: Class<T>) : T {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }


    suspend fun <T> safeApiCall(apiCall: suspend  () -> T) : Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                Resource.Success(apiCall.invoke())
            }

            catch (e: Exception) {
                Resource.Failure(e)
            }
        }
    }
}