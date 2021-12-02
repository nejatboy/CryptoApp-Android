package com.loodos.cryptoapp.services.firebase

abstract class BaseFirebaseService {

    var messageListener: ((message: String) -> Unit)? = null
}