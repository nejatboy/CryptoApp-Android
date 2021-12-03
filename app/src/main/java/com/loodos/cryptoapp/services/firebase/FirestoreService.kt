package com.loodos.cryptoapp.services.firebase

import com.google.firebase.firestore.FirebaseFirestore
import com.loodos.cryptoapp.models.Coin
import java.util.*
import kotlin.collections.ArrayList

class FirestoreService: BaseFirebaseService() {

    private val db = FirebaseFirestore.getInstance()


    fun addCoin(uid: String, coin: Coin, completion: () -> Unit) {

        db.collection("Users").document(uid).collection("Coins").document(UUID.randomUUID().toString()).set(coin)
            .addOnSuccessListener {
                completion.invoke()
            }

            .addOnFailureListener {
                val errorMessage = it.localizedMessage ?: "Coin cannot add to favourites."
                messageListener?.invoke(errorMessage)
            }
    }


    fun fetchFavouriteCoins(uid: String, completion: (ArrayList<Coin>) -> Unit) {
        db.collection("Users").document(uid).collection("Coins").get()
            .addOnSuccessListener {
                val coins = ArrayList<Coin>()

                for (document in it.documents) {
                    val coin = Coin(
                        id = document["id"] as String,
                        name = document["name"] as String,
                        symbol = document["symbol"] as String
                    )

                    coins.add(coin)
                }

                completion.invoke(coins)
            }

            .addOnFailureListener {
                val errorMessage = it.localizedMessage ?: "An unexpected error has occurred."
                messageListener?.invoke(errorMessage)
            }
    }
}