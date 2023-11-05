package com.mangosociety.friendlychallengetime.shared.component.game.create.type

import com.mangosociety.friendlychallengetime.shared.component.game.create.GameType

interface CreateGameTypeComponent {

    fun onChooseGameClicked(type: GameType)
    fun onBackClicked()

}