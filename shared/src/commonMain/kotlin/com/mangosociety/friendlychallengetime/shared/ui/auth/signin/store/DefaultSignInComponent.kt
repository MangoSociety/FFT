package com.mangosociety.friendlychallengetime.shared.ui.auth.signin.store

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.StateFlow

class DefaultSignInComponent(
    componentContext: ComponentContext,
    storeFactory: StoreFactory
) : SignInComponent, ComponentContext by componentContext {

    private val signInStore =
        instanceKeeper.getStore {
            SignInStoreFactory(
                storeFactory = storeFactory
            ).create()
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    override val state: StateFlow<SignInStore.State> = signInStore.stateFlow

    override fun onEvent(event: SignInStore.Intent) {
        signInStore.accept(event)
    }

    fun onOutput(output: Output) {
//        output(output)
    }

    sealed class Output {
        object NavigateBack : Output()
    }

}