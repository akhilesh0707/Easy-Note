package com.aqube.notes.core.presentation.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

@Composable
fun LabelView(title: String, color: Color = MaterialTheme.colors.onPrimary) {
    Text(
        text = title,
        style = typography.subtitle1,
        textAlign = TextAlign.Start,
        color = color
    )
}