package com.mangosociety.friendlychallengetime.compose.content.home.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mangosociety.friendlychallengetime.R
import com.mangosociety.friendlychallengetime.shared.component.content.home.list.HomeComponent
import com.mangosociety.friendlychallengetime.ui.theme.statusBarColor

@Composable
internal fun HomeContent(
    component: HomeComponent,
    modifier: Modifier
) {

    var isAddGameClicked by remember {
        mutableStateOf(false)
    }

    val interactionSource = remember { MutableInteractionSource() }

    Box(modifier = modifier) {

        Column(
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            Text(
                text = stringResource(id = R.string.home_header),
                fontSize = 24.sp,
                color = Color(0xFF594888),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 24.dp)
            )

            LazyColumn(
                contentPadding = PaddingValues(6.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 8.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                for (item in 1..16) {
                    item {
                        GameItem(
                            item
                        ) { component.onOpenGameClicked(it) }
                    }
                }
            }

            Icon(
                painter = painterResource(id = R.drawable.ic_add_off),
                contentDescription = "",
                tint = getColorAddIcon(isAddGameClicked),
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(8.dp)
            )
        }

        if (isAddGameClicked) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f)) // Затемнение с уровнем прозрачности 0.5

            )
        }

        Column(
            modifier = Modifier
                .widthIn(max = 300.dp)
                .align(Alignment.BottomEnd)
                .padding(8.dp)
        ) {

            if (isAddGameClicked) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(alignment = Alignment.Start)
                        .padding(6.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFF1EAFF)
                    ),
                    enabled = true,
                    shape = RoundedCornerShape(4.dp),
                    onClick = {
                        isAddGameClicked = !isAddGameClicked
                        component.onCreatedGame()
                        component.actionDarkLayout(isAddGameClicked)
                    }) {
                    Text(
                        text = "Создать игру",
                        color = Color(0xFF594888),
                        fontSize = 16.sp,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Start
                    )
                }

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(alignment = Alignment.Start)
                        .padding(6.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFF1EAFF)
                    ),
                    enabled = true,
                    shape = RoundedCornerShape(4.dp),
                    onClick = { }) {
                    Text(
                        text = "Присоединиться к игре",
                        color = Color(0xFF594888),
                        fontSize = 16.sp,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Start
                    )
                }

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(alignment = Alignment.Start)
                        .padding(6.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFF1EAFF)
                    ),
                    enabled = true,
                    shape = RoundedCornerShape(4.dp),
                    onClick = {
                        isAddGameClicked = !isAddGameClicked
                        component.actionDarkLayout(isAddGameClicked)
                    }) {
                    Text(
                        text = "Закрыть",
                        color = Color(0xFF594888),
                        fontSize = 16.sp,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Start
                    )
                }
            }

            Icon(
                painter = painterResource(id = R.drawable.ic_add_off),
                contentDescription = "",
                tint = getColorAddIcon(isAddGameClicked),
                modifier = Modifier
                    .padding(top = 6.dp)
                    .align(Alignment.End)
                    .clickable(
                        onClick = {
                            isAddGameClicked = !isAddGameClicked
                            component.actionDarkLayout(isAddGameClicked)
                        },
                        interactionSource = interactionSource,
                        indication = null
                    )
            )
        }
    }
}

@Composable
private fun GameItem(
    index: Int,
    onClick: (Int) -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF1EAFF))
            .padding(8.dp)
            .clickable {
                onClick.invoke(index)
            }
    ) {
        Row(
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Icon(
                modifier = Modifier
                    .size(60.dp),
                painter = painterResource(id = R.drawable.ic_food_fast),
                contentDescription = ""
            )

            Column {
                Text(
                    text = "Название",
                    fontSize = 16.sp,
                    color = Color(0xFF594888),
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(vertical = 4.dp)
                )

                Text(
                    text = "Обычная игра",
                    fontSize = 16.sp,
                    color = Color(0xFF594888),
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(vertical = 4.dp)
                )
            }
        }

        Icon(
            tint = Color(0xFF594888),
            painter = painterResource(id = R.drawable.ic_nav_chat),
            contentDescription = "",
            modifier = Modifier
                .size(32.dp)
                .align(Alignment.TopEnd)
        )

        Text(
            text = "$index участников",
            fontSize = 16.sp,
            color = Color(0xFF594888),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(vertical = 4.dp)
        )


    }

}

private fun getColorAddIcon(currentAction: Boolean): Color {
    return if (currentAction) {
        Color.White
    } else {
        Color(0xFF594888)
    }
}