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

@Entity(tableName = "jokes")
data class Joke (

    val created_at: String,
    val icon_url: String,

    @PrimaryKey
    val id: String,
    val updated_at: String,
    val url: String,
    val value: String
)



