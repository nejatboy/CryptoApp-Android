package com.loodos.cryptoapp.models

import com.google.gson.annotations.SerializedName

data class CoinMarketData(

    @SerializedName("current_price")
    val currentPrice: CoinPrice?,

    @SerializedName("price_change_percentage_24h")
    val priceChanged24h: Double?
)