package com.mangosociety.friendlychallengetime.shared.component.main

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.mangosociety.friendlychallengetime.shared.component.content.chat.ChatComponent
import com.mangosociety.friendlychallengetime.shared.component.content.friend.FriendComponent
import com.mangosociety.friendlychallengetime.shared.component.content.gallery.GalleryComponent
import com.mangosociety.friendlychallengetime.shared.component.content.home.list.HomeComponent
import com.mangosociety.friendlychallengetime.shared.component.content.profile.ProfileComponent
import kotlinx.coroutines.flow.MutableStateFlow

interface MainComponent {

    val childStack: Value<ChildStack<*, Child>>
    val actionDarkTheme: MutableStateFlow<Boolean>

    fun onGalleryTabClicked()
    fun onChatTabClicked()
    fun onHomeTabClicked()
    fun onFriendsTabClicked()
    fun onProfileTabClicked()

    fun onCreateGameClicked()
    fun onJoinedGameClicked()
    fun onOpenGameClicked(gameId: Int)

    sealed class Child {
        class GalleryChild(val component: GalleryComponent) : Child()
        class ChatChild(val component: ChatComponent) : Child()
        class HomeChild(val component: HomeComponent) : Child()
        class FriendChild(val component: FriendComponent) : Child()
        class ProfileChild(val component: ProfileComponent) : Child()
    }

}