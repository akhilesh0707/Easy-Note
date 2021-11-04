package com.aqube.notes.core.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.aqube.notes.core.presentation.theme.White
import com.aqube.notes.core.presentation.theme.Yellow600

@Composable
fun ScaffoldWithFAB(
    label: String,
    icon: Painter,
    scaffoldState: ScaffoldState,
    onClick: () -> Unit,
    content: @Composable() () -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onClick()
                },
                backgroundColor = Yellow600
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = icon,
                    contentDescription = label,
                    tint = White
                )
            }
        },
        scaffoldState = scaffoldState
    ) {
        content()
    }

}