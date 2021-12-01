package com.loodos.cryptoapp.ui.login

import android.app.Application
import com.loodos.cryptoapp.base.BaseViewModel
import com.loodos.cryptoapp.services.firebase.AuthService

class ProfileViewModel(application: Application) : BaseViewModel(application) {

    val authService = AuthService()


    fun requestLogin(email: String, password: String) = authService.login(email, password) {    firebaseUser ->
        println("asd")
    }
}