package com.loodos.cryptoapp.repository

import com.newgamesoftware.moviesdemo_android_mvvm.service.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class BaseRepository {

    val apiKey = "d53aec0276d4b68b29114b8ead2b66fc"


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