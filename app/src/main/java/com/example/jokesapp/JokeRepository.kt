package com.example.jokesapp

import android.util.Log
import kotlinx.coroutines.flow.Flow

class JokeRepository(private val jokeService: JokeService, private val jokeDao: JokeDao) {
    val jokes: Flow<List<Joke>> = jokeDao.getAll()

    suspend fun insertJoke(){
        val result = jokeService.getJoke()

        if (result.body() != null){
            jokeDao.insert(result.body()!!)

            Log.d(null, result.body()!!.value)
        }
    }


}