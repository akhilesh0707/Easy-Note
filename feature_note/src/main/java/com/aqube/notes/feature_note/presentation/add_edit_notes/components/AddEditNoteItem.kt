package com.aqube.notes.feature_note.presentation.add_edit_notes.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aqube.notes.core.presentation.components.TextInputField
import com.aqube.notes.core.presentation.theme.PaleBlack
import com.aqube.notes.feature_note.presentation.add_edit_notes.AddEditNoteEvent
import com.aqube.notes.feature_note.presentation.add_edit_notes.AddEditNoteViewModel

@ExperimentalComposeUiApi
@Composable
fun AddEditNoteItem(
    viewModel: AddEditNoteViewModel
) {
    val titleState = viewModel.title.value
    val contentState = viewModel.content.value

    TextInputField(
        label = titleState.hint,
        value = titleState.text,
        color = PaleBlack,
        onValueChanged = { viewModel.onEvent(AddEditNoteEvent.EnteredTitle(it)) }
    )

    Spacer(modifier = Modifier.height(24.dp))

    TextInputField(
        label = contentState.hint,
        value = contentState.text,
        color = PaleBlack,
        singleLine = false,
        onValueChanged = { viewModel.onEvent(AddEditNoteEvent.EnteredContent(it)) }
    )
}