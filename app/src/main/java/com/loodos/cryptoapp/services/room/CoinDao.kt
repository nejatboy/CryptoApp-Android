package com.loodos.cryptoapp.services.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.loodos.cryptoapp.models.Coin

@Dao
interface CoinDao {

    @Insert
    suspend fun insertAll(vararg coins: Coin) : List<Long>


    @Query("SELECT * FROM coin")
    suspend fun fetchAllCoins() : List<Coin>


    @Query("SELECT * FROM coin WHERE name LIKE '%' || :search || '%'")
    suspend fun findCoin(search: String) : List<Coin>



    /*@Query("SELECT * FROM coin WHERE uuid = :id")
    suspend fun fetchCoin(id: String) : Coin


    @Query("SELECT * FROM coin")
    suspend fun clear()*/
}