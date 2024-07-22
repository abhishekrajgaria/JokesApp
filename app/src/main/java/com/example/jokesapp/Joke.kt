package com.example.jokesapp

/*
Author - Abhishek Rajgaria
 */

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

@Entity
class Joke (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val joke: String
)

@Dao
interface JokeDao {
    @Query("SELECT * FROM joke")
    fun getAll(): List<Joke>

    @Insert
    fun insert(joke: Joke)

    @Delete
    fun delete(joke: Joke)
}

@Database(entities = [Joke::class], version = 1)
abstract class JokeDatabase: RoomDatabase() {
    abstract fun jokeDao(): JokeDao
}