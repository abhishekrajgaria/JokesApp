package com.example.jokesapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class JokeViewModel(private val jokeRepository: JokeRepository) : ViewModel() {

    private val _jokes = MutableStateFlow<List<Joke>>(emptyList())

    val jokes: StateFlow<List<Joke>> = _jokes.asStateFlow()

    init {
        viewModelScope.launch {
            jokeRepository.jokes.collect { jokeList ->
                _jokes.value = jokeList

            }
        }
    }

    fun fetchJoke(){
        viewModelScope.launch {
            jokeRepository.insertJoke()
        }
    }
}