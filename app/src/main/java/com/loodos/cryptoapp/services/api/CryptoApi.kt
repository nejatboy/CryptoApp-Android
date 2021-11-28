package com.loodos.cryptoapp.services.api

import com.loodos.cryptoapp.models.Coin
import retrofit2.http.GET

interface CryptoApi {

    @GET("/api/v3/coins/list")
    suspend fun fetchCoins() : ArrayList<Coin>

}