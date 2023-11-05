package com.mangosociety.friendlychallengetime.shared.component.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.mangosociety.friendlychallengetime.shared.component.game.create.GameType
import com.mangosociety.friendlychallengetime.shared.component.game.create.friends.CreateGameFriendsComponent
import com.mangosociety.friendlychallengetime.shared.component.game.create.type.CreateGameTypeComponent
import com.mangosociety.friendlychallengetime.shared.component.game.process.GameProcessComponent
import com.mangosociety.friendlychallengetime.shared.component.main.MainComponent
import com.mangosociety.friendlychallengetime.shared.component.questioning.QuestioningComponent
import com.mangosociety.friendlychallengetime.shared.component.signIn.SignInComponent
import com.mangosociety.friendlychallengetime.shared.component.signUp.SignUpComponent

interface RootComponent {

    val stack: Value<ChildStack<*, Child>>

//    fun onCreatedGameClicked()
//    fun onChooseGameTypeClicked(type: GameType)
//    fun onOpenGameClicked(gameId: Int)
    fun onBackClicked(toIndex: Int)
    fun onBackClicked()

    sealed class Child {
        class SignIn(val component: SignInComponent) : Child()
        class SignUp(val component: SignUpComponent) : Child()
        class Questioning(val comoponent: QuestioningComponent) : Child()
        class Main(val component: MainComponent) : Child()
        class CreateGameType(val component: CreateGameTypeComponent) : Child()
        class CreateGameFriends(val component: CreateGameFriendsComponent, val type: GameType) : Child()
        class OpenGame(val component: GameProcessComponent, val gameId: Int) : Child()
    }

}