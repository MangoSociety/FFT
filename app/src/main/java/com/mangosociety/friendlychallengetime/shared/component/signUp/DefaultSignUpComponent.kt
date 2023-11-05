package com.mangosociety.friendlychallengetime.shared.component.signUp

import com.arkivanov.decompose.ComponentContext

class DefaultSignUpComponent(
    private val componentContext: ComponentContext,
    private val onFinished: () -> Unit
) : SignUpComponent, ComponentContext by componentContext {

    override fun onBackClicked() {
        onFinished()
    }

}