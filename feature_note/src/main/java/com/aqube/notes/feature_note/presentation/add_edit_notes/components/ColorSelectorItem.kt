package com.aqube.notes.feature_note.presentation.add_edit_notes.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector4D
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import com.aqube.notes.feature_note.domain.model.Note
import com.aqube.notes.feature_note.presentation.add_edit_notes.AddEditNoteEvent
import com.aqube.notes.feature_note.presentation.add_edit_notes.AddEditNoteViewModel
import kotlinx.coroutines.launch

@Composable
fun ColorSelectorItem(
    viewModel: AddEditNoteViewModel,
    noteBackgroundAnim: Animatable<Color, AnimationVector4D>
) {
    val scope = rememberCoroutineScope()

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    )
    {
        Note.noteColors.forEach { color ->
            val colorInt = color.toArgb()
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .shadow(10.dp)
                    .background(color)
                    .border(
                        width = 1.dp,
                        color = if (viewModel.color.value == colorInt)
                            Color.Black
                        else
                            Color.Transparent,
                    )
                    .clickable {
                        scope.launch {
                            noteBackgroundAnim.animateTo(
                                targetValue = Color(colorInt),
                                animationSpec = tween(500)
                            )
                        }
                        viewModel.onEvent(AddEditNoteEvent.ChangeColor(colorInt))
                    }
            )

        }
    }
}