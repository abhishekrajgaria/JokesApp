## JOKES By Chuck Norris


 - Author: Abhishek Rajgaria
 - Github repo: https://github.com/abhishekrajgaria/JokesApp
 - Project Summary: App will fetch jokes from https://api.chucknorris.io/jokes/random and will store it using the Room Database.
 - Features: 
   - Button to fetch a joke
   - Display full list of jokes
   - Database support so that users don't lose old jokes when they close and reopen the app.

### Project Structure

 - app
   - src
     - main
       - java/com/example/jokesapp
         - Joke.kt (Entity class)
         - JokeDao.kt (Data Access Object class)
         - JokeDatabase.kt (Extension of RoomDatabase)
         - JokeRepository.kt (Calls API and Updates Database)
         - JokeService.kt (Implements the Get API)
         - JokeViewModel.kt (For storing the state of App)
         - JokeViewModelFactory.kt (Wrapper for ViewModelProviderFactory)
         - MainActivity.kt (UI)
         - constants.kt (external and constants variables)


### Resources

 - Understanding ViewModel
   - https://developer.android.com/topic/libraries/architecture/viewmodel
   - https://www.youtube.com/watch?v=HBjVSXa8xu8
 - For UI Design
   - https://developer.android.com/develop/ui/compose/components/scaffold
   - https://www.geeksforgeeks.org/spacer-in-android-jetpack-compose/
 - For Entity and Database
   - https://developer.android.com/training/data-storage/room
 - For API using Retrofit2
   - https://www.youtube.com/watch?v=jzeklL787w0
   - https://www.youtube.com/watch?v=uIctBzZGPM8
 - For Flow Update
   - https://developer.android.com/kotlin/flow/stateflow-and-sharedflow