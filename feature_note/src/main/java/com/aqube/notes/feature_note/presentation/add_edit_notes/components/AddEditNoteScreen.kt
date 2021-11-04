package com.aqube.notes.feature_note.presentation.add_edit_notes.components

import androidx.compose.animation.Animatable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aqube.notes.core.presentation.components.ScaffoldWithFAB
import com.aqube.notes.feature_note.R
import com.aqube.notes.feature_note.presentation.add_edit_notes.AddEditNoteEvent
import com.aqube.notes.feature_note.presentation.add_edit_notes.AddEditNoteViewModel
import com.aqube.notes.feature_note.presentation.add_edit_notes.UiEvent
import kotlinx.coroutines.flow.collectLatest

@ExperimentalComposeUiApi
@Composable
fun AddEditNoteScreen(
    upPress: () -> Unit,
    noteColor: Int,
    viewModel: AddEditNoteViewModel = hiltViewModel()
) {

    val scaffoldState = rememberScaffoldState()

    val noteBackgroundAnimatable = remember {
        Animatable(Color(if (noteColor != -1) noteColor else viewModel.color.value))
    }

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is UiEvent.SaveNote -> {
                    upPress()
                }
                is UiEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(message = event.message)
                }
            }
        }
    }

    ScaffoldWithFAB(
        label = stringResource(id = R.string.add_update_note),
        icon = painterResource(id = R.drawable.ic_save),
        scaffoldState = scaffoldState,
        onClick = {
            viewModel.onEvent(AddEditNoteEvent.SaveNote)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(noteBackgroundAnimatable.value)
                .padding(16.dp)
        ) {
            ColorSelectorItem(viewModel = viewModel, noteBackgroundAnim = noteBackgroundAnimatable)
            Spacer(modifier = Modifier.height(24.dp))
            AddEditNoteItem(viewModel = viewModel)
        }
    }

}