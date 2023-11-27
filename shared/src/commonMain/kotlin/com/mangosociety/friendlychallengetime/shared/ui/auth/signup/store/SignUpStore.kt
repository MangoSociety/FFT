package com.mangosociety.friendlychallengetime.shared.ui.auth.signup.store

import com.arkivanov.mvikotlin.core.store.Store

interface SignUpStore : Store<SignUpStore.Intent, SignUpStore.State, Nothing> {

    sealed class Intent {

    }

    data class State(
        val isLoading: Boolean = false,
        val isSuccess: Boolean = false,
        val error: String? = null
    )

}