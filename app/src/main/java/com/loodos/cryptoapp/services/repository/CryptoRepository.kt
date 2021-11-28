package com.loodos.cryptoapp.services.repository

import com.loodos.cryptoapp.models.Coin
import com.loodos.cryptoapp.services.Resource
import com.loodos.cryptoapp.services.api.CryptoApi

class CryptoRepository: BaseRepository() {

    private val api = buildApi(CryptoApi::class.java)


    suspend fun fetchCoins() : Resource<ArrayList<Coin>> = safeApiCall {
        api.fetchCoins()
    }
}