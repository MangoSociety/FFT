package com.mangosociety.friendlychallengetime.shared.ui.auth.signin.store

import com.mangosociety.friendlychallengetime.shared.ui.auth.signin.store.SignInStore
import kotlinx.coroutines.flow.StateFlow

interface SignInComponent {

    val state: StateFlow<SignInStore.State>

    fun onEvent(event: SignInStore.Intent)
}