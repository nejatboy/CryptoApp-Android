package com.loodos.cryptoapp.ui.splash

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.loodos.cryptoapp.base.BaseViewModel
import com.loodos.cryptoapp.models.Coin
import com.loodos.cryptoapp.services.Resource
import com.loodos.cryptoapp.services.repository.CryptoRepository
import com.loodos.cryptoapp.services.room.CoinDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashViewModel(application: Application) : BaseViewModel(application) {

    private val repository = CryptoRepository()
    val coins = MutableLiveData<ArrayList<Coin>>()


    /*fun requestFetchCoins() {
        viewModelScope.launch {
            val result = repository.fetchCoins()

            (result as? Resource.Success)?.value?.let {
                coins.postValue(it)
                return@launch
            }

            val failure = result as Resource.Failure
            println(failure.exception)
        }
    }*/


    fun requestFetchCoins() = viewModelScope.launch {
        val result = repository.fetchCoins()

        (result as? Resource.Success)?.value?.let {
            coins.postValue(it)
            return@launch
        }

        val failure = result as Resource.Failure
        println(failure.exception)
    }


    fun storeInRoomDatabase(coins: ArrayList<Coin>) = viewModelScope.launch(Dispatchers.IO) {
        val dao = CoinDatabase(getApplication()).coinDao()
        //dao.insertAll(*coins.toTypedArray())

        val sss = dao.findCoin("siam")

        println("asd")
    }
}