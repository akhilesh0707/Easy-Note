package com.aqube.notes.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.aqube.notes.core.R
import com.aqube.notes.core.navigation.MainActions

@Composable
fun HeaderItem(
    actions: MainActions,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = stringResource(id = R.string.my_notes),
            style = MaterialTheme.typography.h1,
        )
        IconButton(
            onClick = { actions.gotoSettings() }
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_settings),
                modifier = Modifier.size(24.dp),
                contentDescription = stringResource(id = R.string.settings)
            )
        }
    }
}