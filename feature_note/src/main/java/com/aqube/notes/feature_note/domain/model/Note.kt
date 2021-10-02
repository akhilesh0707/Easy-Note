package com.aqube.notes.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.aqube.notes.core.presentation.theme.*

@Entity
data class Note(
    @PrimaryKey val id: Int? = null,
    val title: String,
    val content: String,
    val timeStamp: Long,
    val color: Int
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}
