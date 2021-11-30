package com.loodos.cryptoapp.ui.detail

import android.app.Application
import com.loodos.cryptoapp.base.BaseViewModel
import com.loodos.cryptoapp.services.firebase.AuthService

class DetailViewModel(application: Application) : BaseViewModel(application) {

    private val authService = AuthService()


    fun getFirebaseUser() = authService.getCurrentUserIfExist()


}