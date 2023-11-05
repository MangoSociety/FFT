package com.mangosociety.friendlychallengetime.shared.component.content.home.list

interface HomeComponent {

    fun onCreatedGame()
    fun onOpenGameClicked(gameId: Int)

    fun actionDarkLayout(action: Boolean)

}