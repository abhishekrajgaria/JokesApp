package com.example.jokesapp

class JokeRepository(private val jokeService: JokeService, private val jokeDao: JokeDao) {
    val jokes: List<Joke> = jokeDao.getAll()

    suspend fun getAndInsertJoke(){
        val result = jokeService.getJoke()

        val joke: Joke? = result.body()
        if (joke!=null){
            jokeDao.insert(joke)
        }
    }
}