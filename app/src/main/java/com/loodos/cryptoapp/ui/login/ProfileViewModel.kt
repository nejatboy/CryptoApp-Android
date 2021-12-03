package com.loodos.cryptoapp.ui.login

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseUser
import com.loodos.cryptoapp.base.BaseViewModel
import com.loodos.cryptoapp.models.Coin
import com.loodos.cryptoapp.services.firebase.AuthService
import com.loodos.cryptoapp.services.firebase.FirestoreService

class ProfileViewModel(application: Application) : BaseViewModel(application) {

    val authService = AuthService()
    val fireStoreService = FirestoreService()


    val firebaseUser = MutableLiveData<FirebaseUser>()
    val favouriteCoins = MutableLiveData<ArrayList<Coin>>()

    fun requestGetCurrentUser() = authService.getCurrentUserIfExist()


    fun requestLogin(email: String, password: String) = authService.login(email, password) {
        firebaseUser.postValue(it)
    }


    fun requestFetchFavouriteCoins() {
        val uid = authService.getCurrentUserIfExist()?.uid ?: return

        fireStoreService.fetchFavouriteCoins(uid) {
            favouriteCoins.postValue(it)
        }
    }
}