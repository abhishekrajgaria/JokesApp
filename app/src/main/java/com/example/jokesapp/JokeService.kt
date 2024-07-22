package com.example.jokesapp


import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface JokeService {
    @GET("jokes/random")
    fun getJoke(): Response<Joke>
}

object JokeServiceHelper{

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(constants.JOKE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

