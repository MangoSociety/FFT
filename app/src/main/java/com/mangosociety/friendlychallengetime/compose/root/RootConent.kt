package com.mangosociety.friendlychallengetime.compose.root

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.mangosociety.friendlychallengetime.compose.content.game.create.friends.CreateGameFriendsContent
import com.mangosociety.friendlychallengetime.compose.content.game.create.type.CreateGameContent
import com.mangosociety.friendlychallengetime.compose.content.game.process.GameProcessContent
import com.mangosociety.friendlychallengetime.compose.content.main.MainContent
import com.mangosociety.friendlychallengetime.compose.questioning.QuestioningContent
import com.mangosociety.friendlychallengetime.compose.signIn.SignInContent
import com.mangosociety.friendlychallengetime.compose.signUp.SignUpContent
import com.mangosociety.friendlychallengetime.shared.component.game.process.GameProcessComponent
import com.mangosociety.friendlychallengetime.shared.component.root.RootComponent
import com.mangosociety.friendlychallengetime.shared.component.root.RootComponent.Child
import com.mangosociety.friendlychallengetime.ui.theme.statusBarColor

@Composable
fun RootContent(
    component: RootComponent,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier
            .fillMaxSize()
            .background(statusBarColor)
            .windowInsetsPadding(WindowInsets.systemBars)
    ) {
        Children(
            stack = component.stack,
            modifier = Modifier
                .fillMaxSize()
                .background(statusBarColor),
            animation = stackAnimation(fade() + scale())
        ) {
            when (val instance = it.instance) {
                is Child.SignIn -> SignInContent(component = instance.component)
                is Child.SignUp -> SignUpContent(component = instance.component)
                is Child.Questioning -> QuestioningContent(component = instance.comoponent)
                is Child.Main -> MainContent(component = instance.component, modifier = Modifier)
                is Child.CreateGameType -> CreateGameContent(
                    component = instance.component,
                    modifier = Modifier
                )

                is Child.CreateGameFriends -> CreateGameFriendsContent(
                    component = instance.component,
                    type = instance.type,
                    modifier = Modifier
                )
                is Child.OpenGame -> GameProcessContent(
                    component = instance.component
                )
            }
        }
    }
}