package com.mangosociety.friendlychallengetime.shared.ui.auth.signin.store

import com.arkivanov.mvikotlin.core.store.Store

interface SignInStore : Store<SignInStore.Intent, SignInStore.State, Nothing> {

    sealed class Intent {
        data class SignInState(val login: String, val password: String): Intent()
//        data class UpdatePokemonFavoriteState(val isFavorite: Boolean): Intent()
    }

    data class State(
        val isLoading: Boolean = false,
        val isSuccess: Boolean = false,
        val error: String? = null,
    )

}