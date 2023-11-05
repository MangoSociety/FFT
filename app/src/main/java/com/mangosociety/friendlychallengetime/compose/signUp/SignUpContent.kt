package com.mangosociety.friendlychallengetime.compose.signUp

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imeNestedScroll
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mangosociety.friendlychallengetime.R
import com.mangosociety.friendlychallengetime.components.InputValidateField
import com.mangosociety.friendlychallengetime.shared.component.signIn.SignInComponent
import com.mangosociety.friendlychallengetime.shared.component.signUp.SignUpComponent

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun SignUpContent(
    component: SignUpComponent,
    modifier: Modifier = Modifier,
) {

    val scrollState = rememberScrollState()

    Scaffold(
        modifier = modifier.fillMaxSize(),
    ) {

        Box(modifier = Modifier.fillMaxSize()) {

            Column {
                Text(
                    stringResource(id = R.string.sign_up_header),
                    color = Color(89, 72, 136),
                    fontSize = 40.sp,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .align(Alignment.CenterHorizontally)
                )

                LazyColumn(
                    modifier = Modifier
                        .imeNestedScroll()
                        .padding(bottom = 16.dp)

                ) {

                    item {
                        Spacer(modifier = Modifier.height(8.dp))

                        InputValidateField(placeholders = stringResource(id = R.string.sign_up_input_fio)) { data ->
                            return@InputValidateField data.isNotBlank()
                        }
                    }

                    item {
                        Spacer(modifier = Modifier.height(8.dp))

                        InputValidateField(placeholders = stringResource(R.string.sign_up_input_nickname)) { data ->
                            return@InputValidateField data.count() > 5
                        }
                    }

                    item {
                        Spacer(modifier = Modifier.height(8.dp))

                        InputValidateField(placeholders = stringResource(id = R.string.sign_up_input_gender)) { data ->
                            return@InputValidateField data.count() > 5
                        }
                    }

                    item {
                        Spacer(modifier = Modifier.height(8.dp))

                        InputValidateField(placeholders = stringResource(id = R.string.sign_up_input_phone)) { data ->
                            return@InputValidateField data.count() > 5
                        }
                    }

                    item {
                        Spacer(modifier = Modifier.height(8.dp))

                        InputValidateField(placeholders = stringResource(id = R.string.sign_up_input_email)) { data ->
                            return@InputValidateField data.count() > 5
                        }
                    }

                    item {
                        Spacer(modifier = Modifier.height(8.dp))

                        InputValidateField(placeholders = stringResource(id = R.string.sign_up_input_country)) { data ->
                            return@InputValidateField data.count() > 5
                        }
                    }

                    item {
                        Spacer(modifier = Modifier.height(8.dp))

                        InputValidateField(placeholders = stringResource(id = R.string.sign_up_input_city)) { data ->
                            return@InputValidateField data.count() > 5
                        }
                    }

                    item {
                        Spacer(modifier = Modifier.height(8.dp))

                        InputValidateField(placeholders = stringResource(id = R.string.sign_up_input_birthday)) { data ->
                            return@InputValidateField data.count() > 5
                        }
                    }

                    item {
                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 64.dp)
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
                                    component.onBackClicked()
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
    }
}