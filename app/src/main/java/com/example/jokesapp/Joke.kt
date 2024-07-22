package com.example.jokesapp

/*
Author - Abhishek Rajgaria
 */

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomDatabase

@Entity
data class Joke (
    val categories: List<String>,
    val created_at: String,
    val icon_url: String,
    val id: String,
    val updated_at: String,
    val url: String,
    val value: String
)

@Dao
interface JokeDao {
    @Query("SELECT * FROM joke")
    suspend fun getAll(): List<Joke>

    @Insert
    suspend fun insert(joke: Joke)

    @Delete
    suspend fun delete(joke: Joke)
}

@Database(entities = [Joke::class], version = 1)
abstract class JokeDatabase : RoomDatabase() {
    abstract fun jokeDao(): JokeDao
}