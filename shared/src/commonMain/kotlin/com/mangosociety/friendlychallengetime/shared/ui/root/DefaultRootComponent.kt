package com.mangosociety.friendlychallengetime.shared.ui.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.popTo
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.mangosociety.friendlychallengetime.shared.ui.auth.signin.store.DefaultSignInComponent
import com.mangosociety.friendlychallengetime.shared.ui.auth.signin.store.SignInComponent

class DefaultRootComponent(
    componentContext: ComponentContext,
    storeFactory: StoreFactory
) : RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    override val stack: Value<ChildStack<*, RootComponent.Child>> =
        childStack(
            source = navigation,
            initialConfiguration = Config.SignIn,
            handleBackButton = true,
            childFactory = ::child,
        )

    private fun child(config: Config, childComponentContext: ComponentContext): RootComponent.Child =
        when (config) {
            is Config.SignIn -> RootComponent.Child.SignIn(signInComponent(childComponentContext))
//            is Config.SignUp -> RootComponent.Child.SignUp(signUpComponent(childComponentContext))
//            is Config.Questioning -> Child.Questioning(questioningComponent(childComponentContext))
//            is Config.Main -> Child.Main(mainComponent(childComponentContext))
//            is Config.CreateGameType -> Child.CreateGameType(createGameTypeComponent(childComponentContext))
//            is Config.CreateGameFriends -> Child.CreateGameFriends(
//                component = createGameFriendsComponent(childComponentContext),
//                type = config.type
//            )
//            is Config.OpenGame -> Child.OpenGame(gameProcessComponent(childComponentContext), config.gameId)
        }

    private fun signInComponent(componentContext: ComponentContext): SignInComponent =
        DefaultSignInComponent(
            componentContext = componentContext,
            storeFactory = DefaultStoreFactory()
//            onShowSignUp = { navigation.push(Config.SignUp) }
        )

//    private fun signUpComponent(componentContext: ComponentContext): SignUpComponent =
//        DefaultSignUpComponent(
//            componentContext = componentContext,
//            onFinished = navigation::pop
//        )
//
//    private fun questioningComponent(componentContext: ComponentContext): QuestioningComponent =
//        DefaultQuestioningComponent(
//            componentContext = componentContext
//        )
//
//    private fun mainComponent(componentContext: ComponentContext): MainComponent =
//        DefaultMainComponent(
//            componentContext = componentContext,
//            onCreatedGame = {
//                onCreatedGameClicked()
//            },
//            onOpenGame = {
//                onOpenGameClicked(it)
//            },
//            onBackClicked = {
//                onBackClicked()
//            }
//        )
//
//    private fun createGameTypeComponent(componentContext: ComponentContext): CreateGameTypeComponent =
//        DefaultCreateGameTypeComponent(
//            componentContext = componentContext,
//            onBackClicked = {
//                onBackClicked()
//            },
//            onChooseGameTypeClicked = {
//                onChooseGameTypeClicked(it)
//            }
//        )
//
//    private fun createGameFriendsComponent(componentContext: ComponentContext): CreateGameFriendsComponent =
//        DefaultCreateGameFriendsComponent(
//            componentContext = componentContext,
//            onBackClicked = {
//                onBackClicked()
//            }
//        )
//
//    private fun gameProcessComponent(componentContext: ComponentContext): GameProcessComponent =
//        DefaultGameProcessComponent(
//            componentContext = componentContext,
//            onBackClicked = ::onBackClicked
//        )

//    override fun onOpenGameClicked(gameId: Int) {
//        navigation.push(Config.OpenGame(gameId))
//    }
//
//    override fun onCreatedGameClicked() {
//        navigation.push(Config.CreateGameType)
//    }
//
//    override fun onChooseGameTypeClicked(type: GameType) {
//        navigation.push(Config.CreateGameFriends(type))
//    }

    override fun onBackClicked(toIndex: Int) {
        navigation.popTo(index = toIndex)
    }

    override fun onBackClicked() {
        navigation.pop()
    }

    private sealed interface Config: Parcelable {

        @Parcelize
        data object SignIn : Config

//        @Parcelize
//        data object SignUp : Config
//
//        @Parcelize
//        data object Questioning : Config
//
//        @Parcelize
//        data object Main : Config
//
//        @Parcelize
//        data object CreateGameType : Config
//
//        @Parcelize
//        data class CreateGameFriends(val type: GameType) : Config
//
//        @Parcelize
//        data class OpenGame(val gameId: Int) : Config
    }

}