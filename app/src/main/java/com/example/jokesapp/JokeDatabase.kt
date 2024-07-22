package com.example.jokesapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Joke::class], version = 1)
abstract class JokeDatabase : RoomDatabase() {
    abstract fun jokeDao(): JokeDao
}