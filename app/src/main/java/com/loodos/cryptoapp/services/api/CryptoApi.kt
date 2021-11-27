package com.loodos.cryptoapp.services.api

import com.loodos.cryptoapp.models.PingResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoApi {

    @GET("/api/v3/ping")
    suspend fun ping() : PingResponseModel


}