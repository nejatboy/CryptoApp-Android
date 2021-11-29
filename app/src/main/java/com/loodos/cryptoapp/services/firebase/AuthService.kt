package com.loodos.cryptoapp.services.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class AuthService {

    private val auth = FirebaseAuth.getInstance()
    var messageListener: ((message: String) -> Unit)? = null


    fun getCurrentUserIfExist() : FirebaseUser? {
        return auth.currentUser
    }


    fun signIn(email: String, password: String, completion: () -> Unit) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                completion.invoke()
            }

            .addOnFailureListener {
                val errorMessage = it.localizedMessage ?: "An unexpected error has occurred."
                messageListener?.invoke(errorMessage)
            }
    }


    fun signUp(email: String, password: String, completion: () -> Unit) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                completion.invoke()
            }

            .addOnFailureListener {
                val errorMessage = it.localizedMessage ?: "An unexpected error has occurred."
                messageListener?.invoke(errorMessage)
            }
    }
}