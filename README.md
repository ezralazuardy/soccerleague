[![License](https://img.shields.io/github/license/ezralazuardy/SoccerLeague)](https://github.com/ezralazuardy/SoccerLeague/blob/master/LICENSE) 
[![Author](https://img.shields.io/badge/author-ezra%20lazuardy-blue.svg)](https://github.com/ezralazuardy) 

## SoccerLeague

A soccer league Android app using SportMonks API. Built with MVVM architecture pattern, and Repository + Singleton design pattern. Written in Kotlin.

### Library used:
  - [**Anko Commons**](https://github.com/Kotlin/anko) (layout, intent, dialog, and snackbar DSL)
  - [**Android Architecture Components**](https://developer.android.com/topic/libraries/architecture) (UI component lifecycle and handling data persistence)
  - [**Glide**](https://github.com/bumptech/glide) (fetching image from url)
  - [**Kotlin Coroutines**](https://github.com/Kotlin/kotlinx.coroutines) (asynchronous operation)
  - [**Retrofit**](https://square.github.io/retrofit/) (fetching API data)
  - [**Room**](https://developer.android.com/topic/libraries/architecture/room) (local database)

Please add your SportMonks API token in **gradle.properties**. If you don't have the token, create it at [SportMonks](https://www.sportmonks.com/). Example:

**SPORTMONKS_API_TOKEN="your-api-token-here"**