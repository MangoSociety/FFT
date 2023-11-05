package com.mangosociety.friendlychallengetime.shared.components.editfield

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputValidateField(
    placeholders: String = "Подсказка",
    onChangeData: (String) -> Unit = {},
    validation: (String) -> Boolean = { true },
) {
    var textValue by remember { mutableStateOf(TextFieldValue("")) }

    val interactionSource = remember { MutableInteractionSource() }
    val enabled = true
    val singleLine = true
    val colors = TextFieldDefaults.outlinedTextFieldColors()

    var backgroundColor by remember {
        mutableStateOf<Long>(0xFFF1EAFF)
    }

    var isFirstChanged by remember {
        mutableStateOf(false)
    }

    var ruleValidateCompleted by remember {
        mutableStateOf<Boolean>(false)
    }

    var isErrorAfterFocusChanged by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 48.dp, vertical = 12.dp)
    ) {
        BasicTextField(
            value = textValue,
            onValueChange = {
                isFirstChanged = true
                onChangeData.invoke(it.text)
                textValue = it
                it.text.apply {
                    if (validation.invoke(this)) {
                        ruleValidateCompleted = true
                    }

                    if (ruleValidateCompleted && !this.contains("@")) {
                        backgroundColor = 0xFFF6D7EC
                    } else {
                        backgroundColor = 0xFFF1EAFF
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 4.dp)
                .background(color = Color(backgroundColor), shape = RoundedCornerShape(4.dp))
                .onFocusChanged { state ->
                    if (!state.isFocused && !validation(textValue.text) && isFirstChanged) {
                        backgroundColor = 0xFFF6D7EC
                        isErrorAfterFocusChanged = true
                    } else {
                        isErrorAfterFocusChanged = false
                    }
                },
            interactionSource = interactionSource,
            enabled = enabled,
            textStyle = MaterialTheme.typography.bodySmall.copy(color = Color(0xFF594888)),
            singleLine = singleLine
        ) {

            if (textValue.text.isNotEmpty()) {
                OutlinedTextFieldDefaults.DecorationBox(
                    value = textValue.text,
                    visualTransformation = VisualTransformation.None,
                    innerTextField = it,
                    interactionSource = interactionSource,
                    enabled = enabled,
                    singleLine = singleLine,
                    contentPadding = PaddingValues(
                        start = 12.dp,
                        end = 8.dp,
                        top = 6.dp,
                        bottom = 6.dp
                    )
                )
            } else {
                Text(
                    text = placeholders,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(8.dp),
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFFC3ACE9)
                )
            }
        }

        if ((ruleValidateCompleted && !validation(textValue.text)) || isErrorAfterFocusChanged) {
            Text(
                text = "что-то пошло не так",
                fontSize = 14.sp,
                modifier = Modifier.padding(2.dp).align(Alignment.End),
                fontWeight = FontWeight.Bold,
                color = Color(0xFFC05555)
            )
        }
    }


}