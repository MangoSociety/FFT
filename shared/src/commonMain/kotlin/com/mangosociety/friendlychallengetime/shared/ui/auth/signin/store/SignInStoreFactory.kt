package com.mangosociety.friendlychallengetime.shared.ui.auth.signin.store

import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.SimpleBootstrapper
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import com.mangosociety.friendlychallengetime.shared.data.repository.AuthRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class SignInStoreFactory(
    private val storeFactory: StoreFactory,
) : KoinComponent {

    private val repository by inject<AuthRepository>()

    fun create(): SignInStore =
        object : SignInStore,
            Store<SignInStore.Intent, SignInStore.State, Nothing> by storeFactory.create(
                name = "SignInStore",
                initialState = SignInStore.State(),
                bootstrapper = SimpleBootstrapper(Unit),
                executorFactory = ::ExecutorImpl,
                reducer = ReducerImpl
            ) {}

    private sealed class Msg {
        object SignInLoading : Msg()
        object CorrectData : Msg()
        object IncorrectData : Msg()
    }

    private inner class ExecutorImpl :
        CoroutineExecutor<SignInStore.Intent, Unit, SignInStore.State, Msg, Nothing>(
        ) {
        override fun executeAction(action: Unit, getState: () -> SignInStore.State) {
//            loadPokemonInfoByName(pokemonName)
        }

        override fun executeIntent(
            intent: SignInStore.Intent,
            getState: () -> SignInStore.State
        ): Unit =
            when (intent) {
                is SignInStore.Intent.SignInState -> {
                    signInProcess(intent.login, intent.password)
                }
                else -> {}
//                is SignInStore.Intent
            }

        private var loadPokemonInfoByNameJob: Job? = null
        private fun loadPokemonInfoByName(name: String) {
            if (loadPokemonInfoByNameJob?.isActive == true) return

//            loadPokemonInfoByNameJob = scope.launch {
//                dispatch(Msg.PokemonInfoLoading)
//
//                pokemonRepository
//                    .getPokemonFlowByName(name)
//                    .onSuccess { pokemonInfo ->
//                        dispatch(Msg.PokemonInfoLoaded(pokemonInfo))
//                    }
//                    .onFailure { e ->
//                        dispatch(Msg.PokemonInfoFailed(e.message))
//                    }
//            }
        }

        private var signInJob: Job? = null
        private fun signInProcess(login: String, password: String) {
            if (signInJob?.isActive == true) return

            signInJob = scope.launch {
                if (repository.signIn(login, password)) {
                    dispatch(Msg.CorrectData)
                } else {
                    dispatch(Msg.IncorrectData)
                }
//                pokemonRepository.updatePokemonFavoriteState(
//                    name = name,
//                    isFavorite = isFavorite,
//                )
//
//                dispatch(Msg.PokemonInfoFavoriteStateUpdated(isFavorite))
            }
        }
    }

    private object ReducerImpl: Reducer<SignInStore.State, Msg> {
        override fun SignInStore.State.reduce(msg: Msg): SignInStore.State =
            when (msg) {
//                is Msg.PokemonInfoLoading -> DetailsStore.State(isLoading = true)
//                is Msg.PokemonInfoLoaded -> DetailsStore.State(pokemonInfo = msg.pokemonInfo)
//                is Msg.PokemonInfoFailed -> DetailsStore.State(error = msg.error)
//                is Msg.PokemonInfoFavoriteStateUpdated -> copy(pokemonInfo = pokemonInfo?.copy(isFavorite = msg.isFavorite))
                Msg.CorrectData -> copy(isSuccess = true, isLoading = false)
                Msg.IncorrectData -> copy(isSuccess = false, isLoading = false)
                Msg.SignInLoading -> SignInStore.State(isLoading = true)
            }
    }

}