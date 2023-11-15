package com.mangosociety.friendlychallengetime.shared.data.repository

import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.mangosociety.friendlychallengetime.shared.commonMain.UserVerifiedEntity
import com.mangosociety.friendlychallengetime.shared.core.database.dao.AuthDao
import kotlinx.coroutines.delay

class AuthRepository(
    private val dao: AuthDao
) {

    suspend fun signIn(login: String, password: String): Boolean {

        val resp = dao.getAll()
        Log.i("test_database", resp.toString())

        var isCorrectData = false
        var isCompleted = false
        var findId = ""
        val db = Firebase.firestore
        db.collection("user").get()
            .addOnSuccessListener { result ->
                for ( us in result) {
                    val em = us.get("email")
                    val passw = us.get("password")
                    if (em == login && passw == password) {
                        findId = us.id
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
        dao.insert(UserVerifiedEntity(
            id = findId,
            email = login,
            password = password
        ))
        return isCorrectData
    }

}