package com.example.jokesapp

/*
Auther - Abhishek Rajgaria
 */

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface JokeDao {

    // Flow is used for asynchronous updates

    @Query("SELECT * FROM jokes")
    fun getAll(): Flow<List<Joke>>

    @Insert
    suspend fun insert(joke: Joke)
}