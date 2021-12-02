package com.loodos.cryptoapp.services.firebase

import com.google.firebase.firestore.FirebaseFirestore
import com.loodos.cryptoapp.models.Coin
import java.util.*

class FirestoreService {

    private val db = FirebaseFirestore.getInstance()


    fun addCoin(uid: String, coin: Coin, completion: () -> Unit) {

        db.collection("Users").document(uid).collection("Coins").document(UUID.randomUUID().toString()).set(coin)
            .addOnSuccessListener {
                println("asd")
            }

            .addOnFailureListener {
                println("asd")
            }
    }

}