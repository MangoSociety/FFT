package com.mangosociety.friendlychallengetime

import android.app.Application
import com.google.firebase.FirebaseApp
import com.google.firebase.ktx.Firebase

class RDVApp: Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
//        Firebase.ini
    }

}