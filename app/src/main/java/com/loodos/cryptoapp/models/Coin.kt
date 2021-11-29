package com.loodos.cryptoapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Coin(

    //@PrimaryKey
    val id: String,

    val symbol: String,

    val name: String
) {
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0
}