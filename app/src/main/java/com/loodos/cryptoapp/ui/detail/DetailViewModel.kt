package com.loodos.cryptoapp.ui.detail

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.loodos.cryptoapp.base.BaseViewModel
import com.loodos.cryptoapp.models.Coin
import com.loodos.cryptoapp.models.CoinDetail
import com.loodos.cryptoapp.services.Resource
import com.loodos.cryptoapp.services.firebase.AuthService
import com.loodos.cryptoapp.services.firebase.FirestoreService
import com.loodos.cryptoapp.services.repository.CryptoRepository
import kotlinx.coroutines.launch

class DetailViewModel(application: Application) : BaseViewModel(application) {

    private val authService = AuthService()
    private val repository = CryptoRepository()
    val fireStoreService = FirestoreService()

    val coinDetail = MutableLiveData<CoinDetail>()
    val coinInFavourites = MutableLiveData<Coin>()


    fun getFirebaseUser() = authService.getCurrentUserIfExist()


    fun requestFetchCoinDetails(coinId: String) = viewModelScope.launch {
        val result = repository.fetchCoinDetails(coinId = coinId)

        (result as? Resource.Success)?.value?.let {
            coinDetail.postValue(it)
            return@launch
        }

        val failure = result as Resource.Failure
        println(failure.exception)
    }


    fun requestSaveToFavourites(coin: Coin) {
        val uid = getFirebaseUser()?.uid ?: return

        fireStoreService.addCoin(uid, coin) {
            coinInFavourites.postValue(coin)
        }
    }
}