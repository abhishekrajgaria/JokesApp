package com.example.jokesapp

class JokeRepository(private val jokeService: JokeService, private val jokeDao: JokeDao) {


    suspend fun insertJoke(){
        val result = jokeService.getJoke()

        val joke: Joke? = result.body()
        if (joke!=null){
            jokeDao.insert(joke)
        }
    }

    suspend fun getAllJokes(): List<Joke>{
        val jokes: List<Joke> = jokeDao.getAll()
        return jokes
    }
}