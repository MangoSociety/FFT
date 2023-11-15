package com.mangosociety.friendlychallengetime.shared.components.editfield

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
            isValidateError = !validation(it)
            backgroundColor = if (isValidateError) {
                ErrorInputColor
            }
            else {
                DefaultInputColor
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 48.dp, vertical = 12.dp),
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            cursorColor = Color.Black,
            errorIndicatorColor = Color.Transparent,
            errorCursorColor = Color.Black,
            focusedLabelColor = backgroundColor,
            unfocusedContainerColor = backgroundColor,
            focusedContainerColor = backgroundColor,
//            placeholderColor = Color.Gray,
//            textColor = Color.Black,
//            backgroundColor = backgroundColor,
        ),
        singleLine = true,
        shape = RoundedCornerShape(4.dp).apply {  },
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
            .padding(2.dp),
        textAlign = TextAlign.End,
        color = Color(0xFFC05555)
    )
}
