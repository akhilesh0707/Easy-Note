package com.aqube.notes.core.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign

@ExperimentalComposeUiApi
@Composable
fun TextInputField(
    label: String,
    value: String,
    widthPercentage: Float = 1f,
    singleLine: Boolean = true,
    color: Color = MaterialTheme.colors.onPrimary,
    onValueChanged: (String) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(widthPercentage),
        value = value,
        onValueChange = {
            onValueChanged(it)
        },
        label = {
            Text(
                text = label,
                style = typography.subtitle1,
                textAlign = TextAlign.Start, color = color
            )
        },
        textStyle = typography.body1,
        singleLine = singleLine,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
            }
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = color,
            unfocusedBorderColor = color,
            focusedLabelColor = color,
            cursorColor = color,
            textColor = color,
        ),
    )

}
