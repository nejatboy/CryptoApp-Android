package com.loodos.cryptoapp.services.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.loodos.cryptoapp.models.Coin


@Database(entities = [Coin::class], version = 1)
abstract class CoinDatabase : RoomDatabase() {

    abstract fun coinDao() : CoinDao


    companion object {
        @Volatile private var instance: CoinDatabase? = null

        private val lock = Any()



        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            makeDatabase(context).also {
                instance = it
            }
        }

        private fun makeDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            CoinDatabase::class.java,
            "coin_try_database"
        ).build()


        private fun makeDatabasse(context: Context) : CoinDatabase {
            return Room.databaseBuilder(context.applicationContext, CoinDatabase::class.java, "coinDatabase").build()
        }
    }
}