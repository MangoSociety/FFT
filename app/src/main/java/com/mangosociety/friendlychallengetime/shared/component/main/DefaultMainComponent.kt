package com.mangosociety.friendlychallengetime.shared.component.main

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.mangosociety.friendlychallengetime.shared.component.content.chat.DefaultChatComponent
import com.mangosociety.friendlychallengetime.shared.component.content.friend.DefaultFriendComponent
import com.mangosociety.friendlychallengetime.shared.component.content.gallery.DefaultGalleryComponent
import com.mangosociety.friendlychallengetime.shared.component.content.home.list.DefaultHomeComponent
import com.mangosociety.friendlychallengetime.shared.component.content.profile.DefaultProfileComponent
import kotlinx.coroutines.flow.MutableStateFlow

class DefaultMainComponent(
    componentContext: ComponentContext,
    private val onCreatedGame: () -> Unit,
    private val onOpenGame: (Int) -> Unit,
    private val onBackClicked: () -> Unit
) : MainComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    private val stack =
        childStack(
            source = navigation,
            initialConfiguration = Config.Home,
            handleBackButton = true,
            childFactory = ::child,
        )

    override val childStack: Value<ChildStack<*, MainComponent.Child>> = stack

    override val actionDarkTheme: MutableStateFlow<Boolean> = MutableStateFlow(false)

    private fun child(config: Config, componentContext: ComponentContext): MainComponent.Child =
        when (config) {
            is Config.Gallery -> MainComponent.Child.GalleryChild(
                DefaultGalleryComponent(
                    componentContext
                )
            )

            is Config.Chat -> MainComponent.Child.ChatChild(DefaultChatComponent(componentContext))
            is Config.Home -> MainComponent.Child.HomeChild(
                DefaultHomeComponent(
                    componentContext = componentContext,
                    onCreatedGame = ::onCreateGameClicked,
                    onOpenGameClicked = ::onOpenGameClicked,
                    onBackClicked = onBackClicked,
                    onChangeActionDarkLayout = {
                        actionDarkTheme.tryEmit(it)
                    }
                )
            )

            is Config.Friend -> MainComponent.Child.FriendChild(
                DefaultFriendComponent(
                    componentContext
                )
            )

            is Config.Profile -> MainComponent.Child.ProfileChild(
                DefaultProfileComponent(
                    componentContext
                )
            )
        }

    override fun onChatTabClicked() {
        navigation.bringToFront(Config.Chat)
    }

    override fun onFriendsTabClicked() {
        navigation.bringToFront(Config.Friend)
    }

    override fun onHomeTabClicked() {
        navigation.bringToFront(Config.Home)
    }

    override fun onGalleryTabClicked() {
        navigation.bringToFront(Config.Gallery)
    }

    override fun onProfileTabClicked() {
        navigation.bringToFront(Config.Profile)
    }

    override fun onCreateGameClicked() {
        onCreatedGame.invoke()
    }

    override fun onJoinedGameClicked() {
        TODO("Not yet implemented")
    }

    override fun onOpenGameClicked(gameId: Int) {
        onOpenGame.invoke(gameId)
    }

    private sealed interface Config : Parcelable {

        @Parcelize
        data object Gallery : Config

        @Parcelize
        data object Chat : Config

        @Parcelize
        data object Home : Config

        @Parcelize
        data object Friend : Config

        @Parcelize
        data object Profile : Config

    }

}