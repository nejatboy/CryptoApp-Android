package com.loodos.cryptoapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Coin(
    val id: String,
    val symbol: String,
    val name: String

) : Serializable {
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0
}