package com.mangosociety.friendlychallengetime.shared.component.content.home.list

import com.arkivanov.decompose.ComponentContext

class DefaultHomeComponent(
    componentContext: ComponentContext,
    private val onCreatedGame: () -> Unit,
    private val onOpenGameClicked: (Int) -> Unit,
    private val onBackClicked: () -> Unit,
    private val onChangeActionDarkLayout: (Boolean) -> Unit
) : HomeComponent, ComponentContext by componentContext{

    override fun onCreatedGame() {
        onCreatedGame.invoke()
    }

    override fun onOpenGameClicked(gameId: Int) {
        onOpenGameClicked.invoke(gameId)
    }

    override fun actionDarkLayout(action: Boolean) {
        onChangeActionDarkLayout.invoke(action)
    }

}