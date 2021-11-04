package com.aqube.notes.feature_note.presentation.notes.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.aqube.notes.core.R
import com.aqube.notes.core.presentation.components.TextInputField
import com.aqube.notes.feature_note.presentation.notes.NotesEvent
import com.aqube.notes.feature_note.presentation.notes.NotesViewModel

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Composable
fun NoteFilterItem(
    viewModel: NotesViewModel
) {
    val noteSearchState = viewModel.search.value
    val state = viewModel.state.value

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        TextInputField(
            label = noteSearchState.hint,
            value = noteSearchState.text,
            widthPercentage = 0.85f,
            onValueChanged = { viewModel.onEvent(NotesEvent.SearchNotes(it)) }
        )
        IconButton(
            onClick = { viewModel.onEvent(NotesEvent.ToggleOrderSelection) }
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_filter),
                modifier = Modifier.size(26.dp),
                contentDescription = stringResource(id = R.string.sort)
            )
        }
    }

    AnimatedVisibility(
        visible = state.isOrderSectionVisible,
        enter = fadeIn() + slideInVertically(
            initialOffsetY = { -50 }, animationSpec =
            tween(
                durationMillis = 300,
            )

        ),
    ) {
        OrderSection(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            noteOrder = state.noteOrder,
            onOrderChange = {
                viewModel.onEvent(NotesEvent.Order(it))
            }
        )
    }
}