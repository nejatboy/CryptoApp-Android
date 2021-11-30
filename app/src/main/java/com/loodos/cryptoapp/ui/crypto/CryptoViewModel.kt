package com.loodos.cryptoapp.ui.crypto


import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.loodos.cryptoapp.base.BaseViewModel
import com.loodos.cryptoapp.models.Coin
import com.loodos.cryptoapp.services.room.CoinDatabase
import kotlinx.coroutines.launch


class CryptoViewModel(application: Application) : BaseViewModel(application) {

    val coins = MutableLiveData<List<Coin>>()
    private val dao = CoinDatabase(getApplication()).coinDao()


    fun findCoinsInRoomDatabase(search: String) = viewModelScope.launch {
        coins.postValue(dao.findCoin(search))
    }
}