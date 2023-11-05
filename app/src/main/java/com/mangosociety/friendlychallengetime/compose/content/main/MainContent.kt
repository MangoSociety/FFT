package com.mangosociety.friendlychallengetime.compose.content.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.mangosociety.friendlychallengetime.R
import com.mangosociety.friendlychallengetime.compose.content.chat.ChatContent
import com.mangosociety.friendlychallengetime.compose.content.friend.FriendContent
import com.mangosociety.friendlychallengetime.compose.content.gallery.GalleryContent
import com.mangosociety.friendlychallengetime.compose.content.home.list.HomeContent
import com.mangosociety.friendlychallengetime.compose.content.profile.ProfileContent
import com.mangosociety.friendlychallengetime.shared.component.main.MainComponent

@Composable
internal fun MainContent(
    component: MainComponent,
    modifier: Modifier
) {

    val childStack by component.childStack.subscribeAsState()
    val activeComponent = childStack.active.instance

    val actionDarkState by component.actionDarkTheme.collectAsState()

    Column(modifier = modifier.background(Color(0xFFE2D5F9))) {
        Children(
            stack = childStack,
            modifier = Modifier.weight(weight = 1F),

            // Workaround for https://issuetracker.google.com/issues/270656235
            animation = stackAnimation(fade()),
//            animation = tabAnimation(),
        ) {
            when (val child = it.instance) {
                is MainComponent.Child.GalleryChild -> GalleryContent(
                    component = child.component,
                    modifier = Modifier.fillMaxSize()
                )

                is MainComponent.Child.ChatChild -> ChatContent(
                    component = child.component,
                    modifier = Modifier.fillMaxSize()
                )

                is MainComponent.Child.HomeChild -> HomeContent(
                    component = child.component,
                    modifier = Modifier.fillMaxSize()
                )

                is MainComponent.Child.FriendChild -> FriendContent(
                    component = child.component,
                    modifier = Modifier.fillMaxSize()
                )

                is MainComponent.Child.ProfileChild -> ProfileContent(
                    component = child.component,
                    modifier.fillMaxSize()
                )
            }
        }

        var currentTab by remember {
            mutableIntStateOf(3)
        }

        BottomNavigation(
            modifier = Modifier
                .fillMaxWidth()
                .background(if (actionDarkState) Color.Black.copy(alpha = 0.5f) else Color.Transparent),
            backgroundColor = Color.Transparent,
            elevation = 0.dp
        ) {
            BottomNavigationItem(
                selected = activeComponent is MainComponent.Child.GalleryChild,
                selectedContentColor = Color(0xFF594888),
                unselectedContentColor = Color(0x80594888),
                onClick = {
                    currentTab = 1
                    component.onGalleryTabClicked()
                },
                icon = {
                    Icon(
                        modifier = Modifier.size(32.dp),
                        painter = painterResource(id = R.drawable.ic_nav_gallery),
                        contentDescription = "Counters",
                        tint = getColorFromSelect(1, currentTab)
                    )
                },
            )

            BottomNavigationItem(
                selected = activeComponent is MainComponent.Child.ChatChild,
                onClick = {
                    currentTab = 2
                    component.onChatTabClicked()
                },
                icon = {
                    Icon(
                        modifier = Modifier.size(32.dp),
                        painter = painterResource(id = R.drawable.ic_nav_chat),
                        contentDescription = "Cards",
                        tint = getColorFromSelect(2, currentTab)
                    )
                },
            )

            BottomNavigationItem(
                selected = activeComponent is MainComponent.Child.HomeChild,
                onClick = {
                    currentTab = 3
                    component.onHomeTabClicked()
                },
                icon = {
                    Icon(
                        modifier = Modifier.size(32.dp),
                        painter = painterResource(id = R.drawable.ic_nav_home),
                        contentDescription = "Multi-Pane",
                        tint = getColorFromSelect(3, currentTab)
                    )
                },
            )

            BottomNavigationItem(
                selected = activeComponent is MainComponent.Child.FriendChild,
                onClick = {
                    currentTab = 4
                    component.onFriendsTabClicked()
                },
                icon = {
                    Icon(
                        modifier = Modifier.size(32.dp),
                        painter = painterResource(id = R.drawable.ic_nav_friend),
                        contentDescription = "Dynamic Features",
                        tint = getColorFromSelect(4, currentTab)
                    )
                },
            )

            BottomNavigationItem(
                selected = activeComponent is MainComponent.Child.ProfileChild,
                onClick = {
                    currentTab = 5
                    component.onProfileTabClicked()
                },
                icon = {
                    Icon(
                        modifier = Modifier.size(32.dp),
                        painter = painterResource(id = R.drawable.ic_nav_profile),
                        contentDescription = "Custom Navigation",
                        tint = getColorFromSelect(5, currentTab)
                    )
                },
            )
        }
    }
}

private fun getColorFromSelect(type: Int, selectType: Int): Color {
    return if (type == selectType) {
        Color(0xFF594888)
    } else {
        Color(0x80594888)
    }
}
