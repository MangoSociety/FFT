package com.mangosociety.friendlychallengetime.shared.component.game.create.type

import com.arkivanov.decompose.ComponentContext
import com.mangosociety.friendlychallengetime.shared.component.game.create.GameType

class DefaultCreateGameTypeComponent(
    componentContext: ComponentContext,
    private val onChooseGameTypeClicked: (GameType) -> Unit,
    private val onBackClicked: () -> Unit
) : CreateGameTypeComponent, ComponentContext by componentContext {

    override fun onChooseGameClicked(type: GameType) {
        onChooseGameTypeClicked.invoke(type)
    }

    override fun onBackClicked() {
        onBackClicked.invoke()
    }

}