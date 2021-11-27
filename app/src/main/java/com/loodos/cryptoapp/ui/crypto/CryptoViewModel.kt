package com.loodos.cryptoapp.ui.crypto

import androidx.lifecycle.viewModelScope
import com.loodos.cryptoapp.base.BaseViewModel
import com.loodos.cryptoapp.services.repository.CryptoRepository
import com.loodos.cryptoapp.services.Resource
import kotlinx.coroutines.launch

class CryptoViewModel: BaseViewModel() {

    private val repository = CryptoRepository()


    fun getPing() {
        viewModelScope.launch {
            val result = repository.ping()

            val pingResponseModel = (result as? Resource.Success)?.value ?:run {
                val failure = result as Resource.Failure
                println(failure.exception)
                return@launch
            }

            println("asd")
        }
    }
}