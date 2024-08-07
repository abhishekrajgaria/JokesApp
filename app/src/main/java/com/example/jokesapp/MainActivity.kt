package com.example.jokesapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.jokesapp.ui.theme.JokesAppTheme


/*
Author - Abhishek Rajgaria
 */

class MainActivity : ComponentActivity() {

    // To Initialize non-null property
    private lateinit var jokeViewModel: JokeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val jokeService = JokeServiceHelper.getInstance().create(JokeService::class.java)
        val jokeDatabase = Room.databaseBuilder(
            applicationContext,
            JokeDatabase::class.java, "jokesDB"
        ).build()
        val jokeDao = jokeDatabase.jokeDao()

        val jokeRepository = JokeRepository(jokeService, jokeDao)

        jokeViewModel = ViewModelProvider(this, JokeViewModelFactory(jokeRepository)).get(JokeViewModel::class.java)

        setContent {
                JokeApp(jokeViewModel)
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JokeApp( viewModel: JokeViewModel){

//    val jokes:List<String> = listOf("Joke 1: Hahaha", "Joke 2: Nananan", "Joke 3: Jajaja")
    val jokes:List<Joke> = viewModel.jokes.collectAsState().value

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = "Chuck Norris Jokes"
                    )
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
                modifier = Modifier.height(48.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "@Copyright 2024"
                )
            }
        }
    ){ innerPadding ->
        Column (
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(1.dp)
            ) {

            Button(
                onClick = {viewModel.fetchJoke()},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text("Get Joke")
            }

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(
                modifier= Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(jokes.reversed()) {joke ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.secondaryContainer
                        )
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            textAlign = TextAlign.Left,
                            text = joke.value
                        )
                    }
                }
            }
        }
    }
}