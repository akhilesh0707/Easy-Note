package com.aqube.notes.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aqube.notes.core.presentation.components.DefaultRadioButton
import com.aqube.notes.feature_note.domain.util.NoteOrder
import com.aqube.notes.feature_note.domain.util.OrderType

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    onOrderChange: (NoteOrder) -> Unit
) {
    Column(modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth()) {
            DefaultRadioButton("Title", noteOrder is NoteOrder.Title, onSelect = {
                onOrderChange(NoteOrder.Title(noteOrder.orderType))
            })

            DefaultRadioButton("Date", noteOrder is NoteOrder.Date, onSelect = {
                onOrderChange(NoteOrder.Date(noteOrder.orderType))
            })

            DefaultRadioButton("Color", noteOrder is NoteOrder.Color, onSelect = {
                onOrderChange(NoteOrder.Color(noteOrder.orderType))
            })
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            DefaultRadioButton("Ascending", noteOrder.orderType is OrderType.Ascending, onSelect = {
                onOrderChange(noteOrder.copy(OrderType.Ascending))
            })

            DefaultRadioButton(
                "Descending",
                noteOrder.orderType is OrderType.Descending,
                onSelect = {
                    onOrderChange(noteOrder.copy(OrderType.Descending))
                }
            )
        }
    }
}
