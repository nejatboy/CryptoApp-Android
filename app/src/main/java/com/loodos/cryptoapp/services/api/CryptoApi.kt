package com.loodos.cryptoapp.services.api

import com.loodos.cryptoapp.models.Coin
import com.loodos.cryptoapp.models.CoinDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoApi {

    @GET("/api/v3/coins/list")
    suspend fun fetchCoins() : ArrayList<Coin>


    @GET("/api/v3/coins/{id}")
    suspend fun fetchCoinDetails(
        @Path("id") coinId: String
    ) : CoinDetail
}