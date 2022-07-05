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


<div class="row">
  <div class="column">
    <img src="screenshot1.png" alt="Snow" style="width:32%">
  </div>
  <div class="column">
    <img src="screenshot2.png" alt="Forest" style="width:32%">
  </div>
</div>

## Open-source libraries and the tech stack
- Minimum SDK level 24
- [Kotlin](https://kotlinlang.org/) based.
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) for asynchronous.
- [Koin](https://github.com/InsertKoinIO/koin) for dependency injection.
- Android Jetpack
  - Paging 3 -  for data loading and pagination.
  - ViewBinding - for data binding to views.
  - ViewModel -  for ViewModel and ViewModelProvider usage.
  - Navigation -  for navigation between fragments.
  - Lifecycle
- [Material-Components](https://github.com/material-components/material-components-android) - Material design components.
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit) - construct the REST APIs and paging network data.
- [Timber](https://github.com/JakeWharton/timber) - logging.
- [Moshi](https://github.com/square/moshi/) - A modern JSON library for Kotlin and Java.
- Architecture
  - Repository pattern
  - MVVM Architecture
<br>

## Architecture
HighSchoolDirectory is built using MVVM architecture and a repository pattern.
<p align="center">
  <img src="/previews/architecture.png"/>
</p>

## Open API
HighSchoolDirectory using the [2017 DOE High School Directory](https://dev.socrata.com/foundry/data.cityofnewyork.us/s3k6-pzi2) for constructing RESTful API.<br>
