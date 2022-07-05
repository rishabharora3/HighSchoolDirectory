package com.rishabh.highschooldirectory.di

import com.rishabh.highschooldirectory.data.api.APIService
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 *  DI module for API service
 */
val apiServicesModule = module {
    single<APIService> {
        get<Retrofit>().create(APIService::class.java)
    }
}
