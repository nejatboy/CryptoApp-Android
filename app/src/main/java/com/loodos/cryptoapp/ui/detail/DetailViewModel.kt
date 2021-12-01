package com.loodos.cryptoapp.ui.detail

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.loodos.cryptoapp.base.BaseViewModel
import com.loodos.cryptoapp.services.Resource
import com.loodos.cryptoapp.services.firebase.AuthService
import com.loodos.cryptoapp.services.repository.CryptoRepository
import kotlinx.coroutines.launch

class DetailViewModel(application: Application) : BaseViewModel(application) {

    private val authService = AuthService()
    private val repository = CryptoRepository()


    fun getFirebaseUser() = authService.getCurrentUserIfExist()


    fun requestFetchCoinDetails(coinId: String) = viewModelScope.launch {
        val result = repository.fetchCoinDetails(coinId = coinId)

        (result as? Resource.Success)?.value?.let {
            //coins.postValue(it)
            println("asd")
            return@launch
        }

        val failure = result as Resource.Failure
        println(failure.exception)
    }
}