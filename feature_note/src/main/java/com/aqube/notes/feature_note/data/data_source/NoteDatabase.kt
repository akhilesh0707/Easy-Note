package com.aqube.notes.feature_note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aqube.notes.feature_note.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1,
    exportSchema = true
)
abstract class NoteDatabase : RoomDatabase() {
    abstract val noteDao: NoteDao

    companion object{
        const val DATABASE_NAME = "notes_db"
    }
}