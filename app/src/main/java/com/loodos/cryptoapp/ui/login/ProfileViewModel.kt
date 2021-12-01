package com.loodos.cryptoapp.ui.login

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseUser
import com.loodos.cryptoapp.base.BaseViewModel
import com.loodos.cryptoapp.services.firebase.AuthService

class ProfileViewModel(application: Application) : BaseViewModel(application) {

    val authService = AuthService()
    val firebaseUser = MutableLiveData<FirebaseUser>()
    val sss = MutableLiveData<Nothing>()

    fun requestGetCurrentUser() = authService.getCurrentUserIfExist()


    fun requestLogin(email: String, password: String) = authService.login(email, password) {
        firebaseUser.postValue(it)
    }
}