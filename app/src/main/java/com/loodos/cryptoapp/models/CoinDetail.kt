package com.loodos.cryptoapp.models

import com.google.gson.annotations.SerializedName

data class CoinDetail(
    val id: String,
    val symbol: String,
    val name: String,
    val image: CoinImage?,

    @SerializedName("market_data")
    val marketData: CoinMarketData?,
)