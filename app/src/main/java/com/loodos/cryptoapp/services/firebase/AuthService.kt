package com.loodos.cryptoapp.services.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class AuthService {

    private val auth = FirebaseAuth.getInstance()
    var messageListener: ((message: String) -> Unit)? = null


    fun getCurrentUserIfExist() : FirebaseUser? {
        return auth.currentUser
    }


    private fun signIn(email: String, password: String, completion: (FirebaseUser) -> Unit) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                completion.invoke(it.user!!)
            }

            .addOnFailureListener {
                val errorMessage = it.localizedMessage ?: "An unexpected error has occurred."
                messageListener?.invoke(errorMessage)
            }
    }


    fun login(email: String, password: String, completion: (FirebaseUser) -> Unit) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                completion.invoke(it.user!!)
            }

            .addOnFailureListener {
                val errorMessage = it.localizedMessage ?: "An unexpected error has occurred."

                if (errorMessage == "The email address is already in use by another account.") {
                    signIn(email, password, completion)
                    return@addOnFailureListener
                }

                messageListener?.invoke(errorMessage)
            }
    }
}