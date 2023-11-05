package com.mangosociety.friendlychallengetime.shared.component.game.create.friends

import com.arkivanov.decompose.ComponentContext

class DefaultCreateGameFriendsComponent(
    componentContext: ComponentContext,
    val onBackClicked: () -> Unit
) : CreateGameFriendsComponent, ComponentContext by componentContext {

    override fun onBackClicked() {
        onBackClicked.invoke()
    }

}