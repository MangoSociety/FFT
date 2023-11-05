package com.mangosociety.friendlychallengetime.compose.content.friend

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mangosociety.friendlychallengetime.shared.component.content.chat.ChatComponent
import com.mangosociety.friendlychallengetime.shared.component.content.friend.FriendComponent

@Composable
internal fun FriendContent(
    component: FriendComponent,
    modifier: Modifier
) {
    Column {
        Text("friend")
    }
}