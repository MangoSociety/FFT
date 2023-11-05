package com.mangosociety.friendlychallengetime.compose.content.game.process

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mangosociety.friendlychallengetime.R
import com.mangosociety.friendlychallengetime.shared.component.game.process.GameProcessComponent

@Composable
internal fun GameProcessContent(
    component: GameProcessComponent
) {

    var isDarkContent by remember {
        mutableStateOf(false)
    }

    Box(modifier = Modifier
        .fillMaxSize()
//        .background(if (isDarkContent) Color.Black.copy(alpha = 0.5f) else Color.Transparent
//        )
    ) {
        GameContent(
            onCompleteTask = {
                isDarkContent = true
            }
        )

        if (isDarkContent) {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.85f)))
            ImpressionDialog()
        }
    }
}

@Composable
private fun BoxScope.GameContent(
    onCompleteTask: () -> Unit
) {
    Image(
        modifier = Modifier
            .align(Alignment.TopStart)
            .padding(20.dp),
        painter = painterResource(id = R.drawable.ic_back),
        contentDescription = ""
    )

    Image(
        modifier = Modifier
            .align(Alignment.TopEnd)
            .padding(20.dp),
        painter = painterResource(id = R.drawable.ic_nav_chat),
        contentDescription = ""
    )

    Image(
        modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.TopStart),
        painter = painterResource(id = R.drawable.ic_game_process_star),
        contentDescription = ""
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.TopCenter)
    ) {
        Text(
            text = "Мечта гейм",
            fontSize = 24.sp,
            color = Color(0xFF594888),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 40.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_food_fast),
            contentDescription = "",
            modifier = Modifier
                .padding(top = 6.dp)
                .align(Alignment.CenterHorizontally)
        )
        GameProgressItem(45)

        TaskItem(number = 18, onCompleteTask = onCompleteTask)

        Text(
            text = "3 участника",
            fontSize = 16.sp,
            color = Color(0xFF594888),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 30.dp, top = 8.dp, bottom = 8.dp)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
//                .heightIn(max = 200.dp)
                .padding(horizontal = 16.dp)
                .padding(top = 8.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            for (item in 1..6) {
                item {
                    MemberItem(gender = item % 2 == 0)
                }
            }
        }

        Image(
            painter = painterResource(id = R.drawable.ic_qr_check),
            modifier = Modifier
//                .width(60.dp)
//                .height(60.dp)
                .align(Alignment.End)
                .padding(horizontal = 24.dp, vertical = 24.dp),
            contentDescription = ""
        )
    }
}

@Composable
private fun GameProgressItem(percent: Int) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(
                text = "$percent/100",
                fontSize = 16.sp,
                color = Color(0xFF594888),
                modifier = Modifier
            )
            Image(
                painter = painterResource(id = R.drawable.ic_game_progress),
                contentDescription = "",
                modifier = Modifier.padding(start = 2.dp, bottom = 4.dp)
            )
        }
        LinearProgressIndicator(
            modifier = Modifier
                .height(8.dp)
                .width(120.dp)
                .align(Alignment.CenterHorizontally)
                .padding(top = 4.dp),
            progress = 0.45f,
            trackColor = Color(0xFFF1EAFF),
            color = Color(0xFF594888),
            strokeCap = StrokeCap.Round
        )

    }
}

@Composable
private fun TaskItem(
    number: Int,
    onCompleteTask: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(
                color = Color(0xFFF1EAFF),
                shape = RoundedCornerShape(6.dp)
            )
    ) {
        Text(
            text = "№$number",
            fontSize = 16.sp,
            color = Color(0xFF594888),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 10.dp)
        )

        Text(
            text = "Посетить парк аттракционов вместе с партнером.",
            fontSize = 16.sp,
            color = Color(0xFF594888),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Start)
                .padding(vertical = 8.dp, horizontal = 12.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .padding(bottom = 8.dp)
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
//                    component.onBackClicked()
                }) {
                Text(
                    "пропустить", color = Color(0x80594888),
                    fontSize = 16.sp
                )
            }

            Button(
                modifier = Modifier
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE2D5F9)
                ),
                enabled = true,
                shape = RoundedCornerShape(4.dp),
                onClick = {
                    onCompleteTask.invoke()
                }) {
                Text(
                    "сделано", color = Color(0xFF594888),
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
private fun MemberItem(gender: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFFF1EAFF), shape = RoundedCornerShape(6.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .align(Alignment.CenterStart)
                .padding(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .align(Alignment.CenterVertically)
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

        Image(
            painter = painterResource(id = R.drawable.ic_nav_chat),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(8.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.ic_request_friend_add),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(8.dp)
        )
    }
}