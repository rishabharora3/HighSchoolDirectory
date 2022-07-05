<h1 align="center">HighSchoolDirectory</h1>

[![Github](https://img.shields.io/badge/-Github-000000?style=for-the-badge&logo=Github&logoColor=white)](https://github.com/rishabharora3)

<p align="center">  
A tiny example application called HighSchoolDirectory uses the MVVM design and latest Android application tech stacks.<br>
Utilizing Paging 3 to present data after retrieving it from the network
</p>
<br/>

<p align="center">
<img src="/previews/screenshot.png" width="50%"/>
</p>


<img src="/previews/preview.gif" align="right" width="32%"/>

## Open-source libraries and the tech stack
- Minimum SDK level 24
- [Kotlin](https://kotlinlang.org/) based.
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) for asynchronous.
- [Koin](https://github.com/InsertKoinIO/koin) for dependency injection.
- Android Jetpack
  - Lifecycle - dispose of observing data when lifecycle state changes.
  - ViewModel - UI related data holder, lifecycle aware.
  - ViewBinding - write code that interacts with views.
  - Navigation - navigate in the app.
  - Paging 3 - render list.
- Architecture
  - MVVM Architecture (View - DataBinding - ViewModel - Model)
  - Repository pattern
- [Material-Components](https://github.com/material-components/material-components-android) - Material design components.
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit) - construct the REST APIs and paging network data.
- [Moshi](https://github.com/square/moshi/) - A modern JSON library for Kotlin and Java.
- [Timber](https://github.com/JakeWharton/timber) - logging.
<br>

## Architecture
HighSchoolDirectory is built using MVVM architecture and a repository pattern.
<p align="center">
  <img src="/previews/architecture.png"/>
</p>

## Open API
HighSchoolDirectory using the [2017 DOE High School Directory](https://dev.socrata.com/foundry/data.cityofnewyork.us/s3k6-pzi2) for constructing RESTful API.<br>
