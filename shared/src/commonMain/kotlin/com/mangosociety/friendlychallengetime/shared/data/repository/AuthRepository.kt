package com.mangosociety.friendlychallengetime.shared.data.repository

import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.delay

class AuthRepository {

    suspend fun signIn(login: String, password: String): Boolean {
        var isCorrectData = false
        var isCompleted = false
        val db = Firebase.firestore
        db.collection("user").get()
            .addOnSuccessListener { result ->
                for ( us in result) {
                    val em = us.get("email")
                    val passw = us.get("password")
                    if (em == login && passw == password) {
                        isCorrectData =  true
                        break
                    }
                }
                isCompleted = true
            }
            .addOnFailureListener {
                isCompleted = true
            }
            .addOnCanceledListener {
                isCompleted = true
            }
        while (!isCompleted) {
            delay(500L)
        }
        return isCorrectData
    }

}