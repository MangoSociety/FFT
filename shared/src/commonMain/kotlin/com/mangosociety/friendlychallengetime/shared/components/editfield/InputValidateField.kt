package com.mangosociety.friendlychallengetime.shared.components.editfield

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mangosociety.friendlychallengetime.shared.ui.theme.BackgroundColor
import com.mangosociety.friendlychallengetime.shared.ui.theme.DefaultInputColor
import com.mangosociety.friendlychallengetime.shared.ui.theme.ErrorInputColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputValidateField(
    modifier: Modifier = Modifier,
    placeholders: String = "Подсказка",
    onChangeData: (String) -> Unit = {},
    validation: (String) -> Boolean = { true },
) {
    var textValue by remember { mutableStateOf("") }

    var backgroundColor by remember { mutableStateOf(DefaultInputColor) }
    var isValidateError by remember { mutableStateOf(false) }

    TextField(
        value = textValue,
        onValueChange = {
            textValue = it
            onChangeData(it)
            isValidateError = !(validation(it) || it.isEmpty())
//            backgroundColor = if (isValidateError) {
//                ErrorInputColor
//            }
//            else {
//                DefaultInputColor
//            }
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 48.dp, vertical = 4.dp),
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,

//            cursorColor = Color.Black,
//            errorIndicatorColor = Color.Transparent,
//            errorCursorColor = Color.Black,
//            focusedLabelColor = backgroundColor,
//            errorLabelColor = Color.Red,
            errorLabelColor = Color(0xFFC05555).copy(alpha = 0.1f),
            errorPlaceholderColor = Color(0xFFC05555).copy(alpha = 0.1f),
            errorCursorColor = Color(0xFFC05555).copy(alpha = 0.1f),
            errorLeadingIconColor = Color(0xFFC05555).copy(alpha = 0.1f),
            errorPrefixColor = Color(0xFFC05555).copy(alpha = 0.1f),
            errorSuffixColor = Color(0xFFC05555).copy(alpha = 0.1f),
            errorSupportingTextColor = Color(0xFFC05555).copy(alpha = 0.1f),
            errorTextColor = Color(0xFFC05555).copy(alpha = 0.1f),
            errorTrailingIconColor = Color(0xFFC05555).copy(alpha = 0.1f),
            errorContainerColor = Color(0xFFC05555).copy(alpha = 0.1f),
            unfocusedContainerColor = backgroundColor,
            focusedContainerColor = backgroundColor,
        ),
        isError = !(validation(textValue) || textValue.isEmpty()),
        singleLine = true,
        shape = RoundedCornerShape(4.dp),
        placeholder = {
            Text(text = placeholders, style = MaterialTheme.typography.bodySmall)
        },
        textStyle = MaterialTheme.typography.bodySmall.copy(color = Color(0xFF594888))
    )

    Text(
        text = if (isValidateError) "что-то пошло не так" else "",
        fontSize = 14.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 56.dp),
        textAlign = TextAlign.End,
        color = Color(0xFFC05555)
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicInputValidateField(
    modifier: Modifier = Modifier,
    placeholders: String = "Подсказка",
    onChangeData: (String) -> Unit = {},
    validation: (String) -> Boolean = { true },
) {
    var textValue by remember { mutableStateOf("") }
    var isValidateError by remember { mutableStateOf(false) }

    var backgroundColor by remember { mutableStateOf(DefaultInputColor) }

    BasicTextField(
        value = textValue,
        onValueChange = {
            textValue = it
            onChangeData(it)
            isValidateError = !(validation(it) || it.isEmpty())
            backgroundColor = if (isValidateError) {
                ErrorInputColor
            } else {
                DefaultInputColor
            }
        },
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 48.dp, vertical = 4.dp)
            .border(
                width = 1.dp,
                color = if (isValidateError) Color(0xFFC05555) else Color.Transparent,
                shape = RoundedCornerShape(4.dp)
            ),
        textStyle = MaterialTheme.typography.bodySmall.copy(color = Color(0xFF594888)),
        singleLine = true,
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(backgroundColor)
                    .padding(horizontal = 8.dp, vertical = 12.dp)
            ) {
                if (textValue.isEmpty()) {
                    Text(placeholders, style = MaterialTheme.typography.bodySmall.copy(color = Color(0xFF594888)))
                } else {
                    innerTextField()
                }
            }
        },
    )

    Text(
        text = if (isValidateError) "что-то пошло не так" else "",
        fontSize = 14.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 56.dp),
        textAlign = TextAlign.End,
        color = Color(0xFFC05555)
    )
}