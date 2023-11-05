package com.mangosociety.friendlychallengetime.compose.signIn

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mangosociety.friendlychallengetime.R
import com.mangosociety.friendlychallengetime.components.InputValidateField
import com.mangosociety.friendlychallengetime.shared.component.signIn.SignInComponent

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun SignInContent(
    component: SignInComponent,
    modifier: Modifier = Modifier,
) {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
    ) {

        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
            ) {
                Text(
                    stringResource(id = R.string.sign_in_header),
                    color = Color(89, 72, 136),
                    fontSize = 64.sp,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .padding(bottom = 48.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(16.dp))

                InputValidateField(placeholders = "input email", onChangeData = { email = it }) { data ->
                    return@InputValidateField data.contains("@")
                }

                Spacer(modifier = Modifier.height(16.dp))

                InputValidateField(placeholders = "input password", onChangeData = { password = it }) { data ->
                    return@InputValidateField data.count() > 5
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    modifier = Modifier
                        .width(110.dp)
                        .height(40.dp)
                        .align(alignment = Alignment.CenterHorizontally),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFF1EAFF)
                    ),
                    enabled = true,
                    shape = RoundedCornerShape(4.dp),
                    onClick = { component.onSignInClicked(email, password) }) {
                        Text(
                            stringResource(id = R.string.sign_in_btn), color = Color(0xFF594888),
                            fontSize = 16.sp
                        )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    stringResource(id = R.string.sign_in_recovery_password), color = Color(0xFF594888),
                    fontSize = 20.sp,
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                        .padding(16.dp)
                )
            }

            Text(
                stringResource(id = R.string.sign_in_btn_sign_up), color = Color(0xFF594888),
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp)
            )
        }
    }
}