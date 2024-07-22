package com.example.jokesapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface JokeDao {
    @Query("SELECT * FROM jokes")
    fun getAll(): Flow<List<Joke>>

    @Insert
    suspend fun insert(joke: Joke)
}