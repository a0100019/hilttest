package com.example.hiltcopy.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Insert
    suspend fun insert(todo: Todo)

    @Delete
    suspend fun delete(todo: Todo)

    @Query("SELECT * FROM todo_table ORDER BY id DESC")
    fun getAllTodos(): Flow<List<Todo>>
}