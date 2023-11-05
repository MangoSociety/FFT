package com.mangosociety.friendlychallengetime.compose.questioning

import android.annotation.SuppressLint
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mangosociety.friendlychallengetime.R
import com.mangosociety.friendlychallengetime.components.InputValidateField
import com.mangosociety.friendlychallengetime.shared.component.questioning.QuestioningComponent
import com.mangosociety.friendlychallengetime.ui.theme.Purple80

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun QuestioningContent(
    component: QuestioningComponent,
    modifier: Modifier = Modifier
) {

    var selectedItem by remember {
        mutableIntStateOf(-1)
    }

    var currentCategory by remember {
        mutableIntStateOf(1)
    }

    var openDialog by remember {
        mutableStateOf(false)
    }

    val annotatedText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                textDecoration = TextDecoration.Underline,
                color = Color(0xFFA593C9),
                fontSize = 20.sp
            )
        ) {
            append(stringResource(id = R.string.questioning_skip))
        }
    }

    Scaffold(modifier = modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {

            Column(modifier = Modifier.align(Alignment.Center)) {
                Text(
                    text = "Анкета",
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .align(Alignment.CenterHorizontally),
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF594888)
                )

                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .background(Color(color = 0xFFF1EAFF))
                        .align(Alignment.CenterHorizontally)
                ) {

                    Text(
                        text = stringResource(id = R.string.questioning_type_music),
                        modifier = Modifier
                            .padding(top = 8.dp, bottom = 16.dp)
                            .align(Alignment.CenterHorizontally),
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF594888)
                    )

                    LazyVerticalGrid(columns = GridCells.Fixed(2)) {

                        component.variants.find { it.id == currentCategory }?.let {
                            for (item in it.data) {
                                item {
                                    Column {
                                        Icon(
                                            tint = Color(0xFF594888),
                                            painter = painterResource(id = item.iconId),
                                            contentDescription = "",
                                            modifier = Modifier
                                                .width(86.dp)
                                                .height(86.dp)
                                                .align(Alignment.CenterHorizontally)
                                                .alpha(if (selectedItem == item.id) 1f else 0.3f)
                                                .clickable(
                                                    onClick = {
                                                        if (item.titleId == R.string.questioning_custom) {
                                                            openDialog = true
                                                        }
                                                        selectedItem = item.id
                                                    }
                                                )
                                        )

                                        Text(
                                            text = stringResource(id = item.titleId),
                                            fontSize = 16.sp,
                                            color = Color(0xFF594888),
                                            modifier = Modifier
                                                .align(Alignment.CenterHorizontally)
                                                .padding(bottom = 8.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }

                    Button(
                        onClick = {
                            if (currentCategory < 6) {
                                currentCategory++
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFE2D5F9)
                        ),
                        shape = RectangleShape,
                        modifier = Modifier
                            .padding(top = 16.dp, bottom = 8.dp)
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Text(
                            text = stringResource(id = R.string.questioning_next),
                            fontSize = 16.sp,
                            color = Color(0xFF594888),
                            modifier = Modifier
                        )
                    }
                }
                Button(
                    onClick = {
                        if (currentCategory < 6) {
                            currentCategory++
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 24.dp),) {
                    BasicText(
                        text = annotatedText
                    )
                }}
            }

        if (openDialog) {
            androidx.compose.material3.AlertDialog(
                onDismissRequest = {
                    openDialog = false
                },
                modifier = Modifier.background(Color.Transparent)
            ) {
                Surface(
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                        .background(Color.Transparent),
                    shape = MaterialTheme.shapes.large
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        InputValidateField(
                            placeholders = stringResource(
                                id = component.variants.find { it.id == currentCategory }?.titleId
                                ?: R.string.questioning_custom),
                            validation = { it.isNotEmpty() }
                        )
                    }
                }
            }
        }
        }
    }
