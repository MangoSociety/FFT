package com.mangosociety.friendlychallengetime.compose.content.game.create.type

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mangosociety.friendlychallengetime.R
import com.mangosociety.friendlychallengetime.shared.component.game.create.GameType
import com.mangosociety.friendlychallengetime.shared.component.game.create.type.CreateGameTypeComponent
import com.mangosociety.friendlychallengetime.ui.theme.statusBarColor

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
internal fun CreateGameContent(
    component: CreateGameTypeComponent,
    modifier: Modifier
) {

    Scaffold(
        topBar = {
            Box(modifier = Modifier.fillMaxWidth()) {

                Icon(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopCenter),
                    tint = Color(0xFFFFF4BA),
                    painter = painterResource(id = R.drawable.ic_star_create_game),
                    contentDescription = ""
                )

                IconButton(onClick = { component.onBackClicked() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "",
                        tint = Color(0xFF594888),
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(24.dp)
                    )
                }

                Text(
                    text = "Создать игру",
                    fontSize = 24.sp,
                    color = Color(0xFF594888),
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(vertical = 24.dp)
                )

            }
        },
        modifier = modifier.background(statusBarColor),
        backgroundColor = statusBarColor
    ) { _ ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            Text(
                text = "Выберите режим игры : ",
                color = Color(0xFF594888),
                fontSize = 16.sp,
                textAlign = TextAlign.Start
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
                    .background(Color(0xFFF1EAFF))
            ) {

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Игра для пар",
                        color = Color(0xFF594888),
                        fontSize = 20.sp,
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(start = 10.dp, end = 10.dp, top = 10.dp),
                    )

                    Icon(
                        modifier = Modifier
                            .size(140.dp)
//                            .padding(start = 16.dp)
                            .padding(top = 24.dp)
                            .align(Alignment.CenterHorizontally),
                        painter = painterResource(id = R.drawable.ic_food_fast),
                        contentDescription = "",
                    )
                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 10.dp)
                ) {
                    Button(
                        onClick = {
                            component.onChooseGameClicked(GameType.Romantic.Fast)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFE2D5F9)
                        ),
                        shape = RectangleShape,
                        modifier = Modifier
                            .width(180.dp)
                            .padding(top = 16.dp, bottom = 8.dp)
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Text(
                            text = "быстрая игра",
                            fontSize = 14.sp,
                            color = Color(0xFF594888),
                            modifier = Modifier
                        )
                    }
                    Button(
                        onClick = {
                            component.onChooseGameClicked(GameType.Romantic.Default)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFE2D5F9)
                        ),
                        shape = RectangleShape,
                        modifier = Modifier
                            .width(180.dp)
                            .padding(top = 16.dp, bottom = 8.dp)
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Text(
                            text = "обычная игра",
                            fontSize = 14.sp,
                            color = Color(0xFF594888),
                            modifier = Modifier
                        )
                    }
                    Button(
                        onClick = {
                            component.onChooseGameClicked(GameType.Romantic.WithText)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFE2D5F9)
                        ),
                        shape = RectangleShape,
                        modifier = Modifier
                            .width(180.dp)
                            .padding(top = 16.dp, bottom = 8.dp)
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Text(
                            text = "игра с текстом",
                            fontSize = 14.sp,
                            color = Color(0xFF594888),
                            modifier = Modifier
                        )
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
                    .background(Color(0xFFF1EAFF))
            ) {

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Игра для друзей",
                        color = Color(0xFF594888),
                        fontSize = 20.sp,
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(start = 10.dp, end = 10.dp, top = 10.dp),
                    )

                    Icon(
                        modifier = Modifier
                            .size(140.dp)
//                            .padding(start = 16.dp)
                            .padding(top = 24.dp)
                            .align(Alignment.CenterHorizontally),
                        painter = painterResource(id = R.drawable.ic_food_fast),
                        contentDescription = "",
                    )
                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 10.dp)
                ) {
                    Button(
                        onClick = {
                            component.onChooseGameClicked(GameType.Friends.Fast)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFE2D5F9)
                        ),
                        shape = RectangleShape,
                        modifier = Modifier
                            .width(180.dp)
                            .padding(top = 16.dp, bottom = 8.dp)
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Text(
                            text = "быстрая игра",
                            fontSize = 14.sp,
                            color = Color(0xFF594888),
                            modifier = Modifier
                        )
                    }
                    Button(
                        onClick = {
                            component.onChooseGameClicked(GameType.Friends.Default)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFE2D5F9)
                        ),
                        shape = RectangleShape,
                        modifier = Modifier
                            .width(180.dp)
                            .padding(top = 16.dp, bottom = 8.dp)
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Text(
                            text = "обычная игра",
                            fontSize = 14.sp,
                            color = Color(0xFF594888),
                            modifier = Modifier
                        )
                    }
                    Button(
                        onClick = {
                            component.onChooseGameClicked(GameType.Friends.WithText)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFE2D5F9)
                        ),
                        shape = RectangleShape,
                        modifier = Modifier
                            .width(180.dp)
                            .padding(top = 16.dp, bottom = 8.dp)
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Text(
                            text = "игра с текстом",
                            fontSize = 14.sp,
                            color = Color(0xFF594888),
                            modifier = Modifier
                        )
                    }
                }


            }

        }
    }


}