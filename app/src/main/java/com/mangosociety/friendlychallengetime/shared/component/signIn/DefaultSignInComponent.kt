package com.mangosociety.friendlychallengetime.shared.component.signIn

import android.util.Log
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import com.arkivanov.decompose.ComponentContext
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class DefaultSignInComponent(
    componentContext: ComponentContext,
    private val onShowSignUp: () -> Unit,
) : SignInComponent, ComponentContext by componentContext {

    override fun onSignInClicked(email: String, password: String) {
        val db = Firebase.firestore
        db.collection("user").get()
            .addOnSuccessListener { result ->
                for ( us in result) {

                    Log.i("firestore_test", "user = ${us.get("email")} , pass = ${us.get("password")}")
                }
            }
    }

    override fun onShowSignUpClicked() {
        onShowSignUp()
    }

}