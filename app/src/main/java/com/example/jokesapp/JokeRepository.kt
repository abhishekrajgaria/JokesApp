package com.example.jokesapp


/*
Author - Abhishek Rajgaria
 */

import android.util.Log
import kotlinx.coroutines.flow.Flow

class JokeRepository(private val jokeService: JokeService, private val jokeDao: JokeDao) {
    val jokes: Flow<List<Joke>> = jokeDao.getAll()

    suspend fun insertJoke(){
        val result = jokeService.getJoke()

        val joke: Joke? = result.body()

        if (joke != null){
            jokeDao.insert(joke)

            Log.d(null, joke.value)
        }
    }


}