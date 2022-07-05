package com.rishabh.a20220630_rishabharora_nycschools.di

import com.rishabh.a20220630_rishabharora_nycschools.data.providers.RetrofitProvider
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