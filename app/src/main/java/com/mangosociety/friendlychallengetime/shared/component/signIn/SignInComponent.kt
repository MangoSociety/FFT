package com.mangosociety.friendlychallengetime.shared.component.signIn

interface SignInComponent {

    fun onSignInClicked(email: String, password: String)
    fun onShowSignUpClicked()

}