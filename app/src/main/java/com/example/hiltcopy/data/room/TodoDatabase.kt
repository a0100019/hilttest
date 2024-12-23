package com.example.hiltcopy.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Todo::class, Note::class], version = 2, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
    abstract fun noteDao(): NoteDao
}