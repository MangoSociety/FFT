package com.mangosociety.friendlychallengetime.shared.ui.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.mangosociety.friendlychallengetime.shared.ui.auth.signin.store.SignInComponent

interface RootComponent {

    val stack: Value<ChildStack<*, Child>>

//    fun onCreatedGameClicked()
//    fun onChooseGameTypeClicked(type: GameType)
//    fun onOpenGameClicked(gameId: Int)
    fun onBackClicked(toIndex: Int)
    fun onBackClicked()

    sealed class Child {
        class SignIn(val component: SignInComponent) : Child()
//        class SignUp(val component: SignUpComponent) : Child()
//        class Questioning(val comoponent: QuestioningComponent) : Child()
//        class Main(val component: MainComponent) : Child()
//        class CreateGameType(val component: CreateGameTypeComponent) : Child()
//        class CreateGameFriends(val component: CreateGameFriendsComponent, val type: GameType) : Child()
//        class OpenGame(val component: GameProcessComponent, val gameId: Int) : Child()
    }

}