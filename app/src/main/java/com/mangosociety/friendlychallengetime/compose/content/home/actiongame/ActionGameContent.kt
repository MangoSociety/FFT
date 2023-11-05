package com.mangosociety.friendlychallengetime.compose.content.home.actiongame

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mangosociety.friendlychallengetime.shared.component.content.home.list.HomeComponent

@Composable
internal fun ActionGameContent(
    component: HomeComponent,
    modifier: Modifier
) {

    Column {
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Создать игру")
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Присоединиться к игре")
        }
    }

}