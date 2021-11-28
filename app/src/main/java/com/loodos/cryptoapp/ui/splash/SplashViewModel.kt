package com.loodos.cryptoapp.ui.splash

import androidx.lifecycle.viewModelScope
import com.loodos.cryptoapp.base.BaseViewModel
import com.loodos.cryptoapp.services.Resource
import com.loodos.cryptoapp.services.repository.CryptoRepository
import kotlinx.coroutines.launch

class SplashViewModel: BaseViewModel() {

    private val repository = CryptoRepository()


    fun requestFetchCoins() {
        viewModelScope.launch {
            val result = repository.fetchCoins()

            val coins = (result as? Resource.Success)?.value ?:run {
                val failure = result as Resource.Failure
                println(failure.exception)
                return@launch
            }

            println("asd")
        }
    }
}