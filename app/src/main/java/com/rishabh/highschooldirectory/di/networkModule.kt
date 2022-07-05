package com.rishabh.highschooldirectory.di

import com.rishabh.highschooldirectory.data.providers.RetrofitProvider
import org.koin.dsl.module

private const val BASE_URL = "https://data.cityofnewyork.us/resource/"

/**
 * Module for providing Retrofit instances
 */
val networkModule = module {
    single {
        RetrofitProvider(get(), BASE_URL).provide()
    }
}