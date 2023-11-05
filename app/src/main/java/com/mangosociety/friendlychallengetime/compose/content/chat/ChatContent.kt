package com.mangosociety.friendlychallengetime.compose.content.chat

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mangosociety.friendlychallengetime.shared.component.content.chat.ChatComponent

@Composable
internal fun ChatContent(
    component: ChatComponent,
    modifier: Modifier
) {
    Column {
        Text("chat")
    }
}