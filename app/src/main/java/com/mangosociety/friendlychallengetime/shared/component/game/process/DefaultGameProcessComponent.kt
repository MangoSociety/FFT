package com.mangosociety.friendlychallengetime.shared.component.game.process

import com.arkivanov.decompose.ComponentContext

class DefaultGameProcessComponent(
    private val componentContext: ComponentContext,
    private val onBackClicked: () -> Unit
) : GameProcessComponent, ComponentContext by componentContext {

    override fun onBackClicked() {
        onBackClicked.invoke()
    }

}