package com.loodos.cryptoapp.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDataSource {

    private val baseUrl = "https://api.themoviedb.org/"


    fun <T> buildApi(api: Class<T>) : T {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }

}