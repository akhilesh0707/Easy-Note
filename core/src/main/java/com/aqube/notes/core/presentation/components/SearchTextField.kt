package com.aqube.notes.core.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@ExperimentalComposeUiApi
@Composable
fun SearchTextField(

) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val stateField = remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = stateField.value,
        onValueChange = { value ->
            stateField.value = value
        },
        modifier = Modifier
            .fillMaxWidth(),
        textStyle = TextStyle(color = MaterialTheme.colors.onSurface, fontSize = 18.sp),
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "",
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colors.onSurface
            )
        },
        trailingIcon = {
            if (stateField.value != TextFieldValue("")) {
                IconButton(
                    onClick = {
                        stateField.value =
                            TextFieldValue("") // Remove text from TextField when you press the 'X' icon
                    }
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "",
                        modifier = Modifier
                            .size(24.dp),
                        tint = MaterialTheme.colors.onSurface
                    )
                }
            }
        },
        singleLine = true,
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            cursorColor = Color.Black,
            disabledLabelColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done,
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
            },
        ),
    )
}