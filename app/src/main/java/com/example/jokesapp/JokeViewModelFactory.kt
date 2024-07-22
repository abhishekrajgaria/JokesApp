package com.example.jokesapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class JokeViewModelFactory(private val jokeRepository: JokeRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return JokeViewModel(jokeRepository) as T
    }
}