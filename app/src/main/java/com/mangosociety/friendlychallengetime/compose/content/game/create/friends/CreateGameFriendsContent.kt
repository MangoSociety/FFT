package com.mangosociety.friendlychallengetime.compose.content.game.create.friends

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mangosociety.friendlychallengetime.R
import com.mangosociety.friendlychallengetime.shared.component.game.create.GameType
import com.mangosociety.friendlychallengetime.shared.component.game.create.friends.CreateGameFriendsComponent
import com.mangosociety.friendlychallengetime.ui.theme.statusBarColor

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
internal fun CreateGameFriendsContent(
    component: CreateGameFriendsComponent,
    type: GameType,
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

        var search by remember {
            mutableStateOf("")
        }

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
//                    .fillMaxHeight(0.8f)
                    .align(Alignment.TopCenter),
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    text = "Выберите друзей для игры : ",
                    color = Color(0xFF594888),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Start
                )

                Box(
                    modifier = Modifier.padding(top = 16.dp)
                ) {

                    TextField(
                        value = search,
                        onValueChange = {
                            search = it
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xFFFAF7FF),
                            cursorColor = Color(0xCC594888),
                            focusedTextColor = Color(0xFF594888),
                            unfocusedTextColor = Color(0xCC594888),
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            disabledTextColor = Color.Transparent,
                        ),
                        visualTransformation = VisualTransformation.None

                    )

                    if (search.isEmpty()) {
                        Text(
                            modifier = Modifier
                                .align(Alignment.CenterStart)
                                .padding(start = 16.dp),
                            text = "Поиск ...",
                            color = Color(0xCC594888),
                            fontSize = 16.sp,
                            textAlign = TextAlign.Start
                        )
                    }
                }

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 130.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    for (index in 1..6) {
                        item {
                            FriendItem(gender = index % 2 == 0)
                        }
                    }
                }

            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
//                    .fillMaxHeight(0.2f)
                    .align(Alignment.BottomCenter),
                verticalArrangement = Arrangement.Bottom
            ) {
                Image(
                    modifier = Modifier.align(Alignment.End),
                    painter = painterResource(id = R.drawable.ic_qr_code),
                    contentDescription = ""
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 64.dp)
                        .padding(top = 20.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Button(
                        modifier = Modifier
                            .weight(1f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        ),
                        enabled = true,
                        onClick = {
//                            component.onBackClicked()
                        }) {
                        Text(
                            stringResource(id = R.string.sign_up_btn_back), color = Color(0xFF594888),
                            fontSize = 16.sp
                        )
                    }

                    Button(
                        modifier = Modifier
                            .weight(1f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFF1EAFF)
                        ),
                        enabled = true,
                        shape = RoundedCornerShape(4.dp),
                        onClick = {

                        }) {
                        Text(
                            stringResource(id = R.string.sign_up_btn_next), color = Color(0xFF594888),
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }


    }


}

@Composable
private fun FriendItem(gender: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFFF1EAFF), shape = RoundedCornerShape(6.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .align(Alignment.CenterStart)
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(80.dp)
            ) {
                Icon(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = R.drawable.ic_food_fast),
                    contentDescription = ""
                )
                Image(
                    painter = painterResource(id = if (gender) R.drawable.ic_gender_man else R.drawable.ic_gender_woman),
                    contentDescription = "",
                    modifier = Modifier.align(Alignment.TopEnd)
                )
            }
            Box(
                modifier = Modifier
                    .height(80.dp)
                    .padding(start = 8.dp)
            ) {
                Text(
                    modifier = Modifier
                        .align(Alignment.TopStart),
                    text = "Мария Маркова",
                    color = Color(0xCC594888),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Start
                )

                Text(
                    modifier = Modifier
                        .align(Alignment.BottomStart),
                    text = "20 лет",
                    color = Color(0xCC594888),
                    fontSize = 14.sp,
                    textAlign = TextAlign.Start
                )
            }
        }

        Icon(
            painter = painterResource(id = R.drawable.ic_add_off),
            contentDescription = "",
            tint = Color(0xFF594888),
            modifier = Modifier.align(Alignment.CenterEnd)
        )
    }
}