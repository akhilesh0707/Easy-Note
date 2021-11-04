package com.aqube.notes.feature_settings.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun SettingsItem(
    label: String,
    icon: Painter,
    content: @Composable() () -> Unit,
    itemClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .height(60.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 4.dp, bottom = 4.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colors.secondary),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Row(
                modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = icon,
                    modifier = Modifier
                        .size(26.dp),
                    contentDescription = label
                )
                Text(
                    modifier = Modifier.padding(start = 8.dp),
                    text = label,
                    style = MaterialTheme.typography.h5,
                    color = MaterialTheme.colors.onPrimary
                )

            }
            content()
        }
    }
}