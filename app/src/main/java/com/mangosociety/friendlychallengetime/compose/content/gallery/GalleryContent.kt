package com.mangosociety.friendlychallengetime.compose.content.gallery

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mangosociety.friendlychallengetime.shared.component.content.chat.ChatComponent
import com.mangosociety.friendlychallengetime.shared.component.content.gallery.GalleryComponent

@Composable
internal fun GalleryContent(
    component: GalleryComponent,
    modifier: Modifier
) {
    Column {
        Text("gallery")
    }
}