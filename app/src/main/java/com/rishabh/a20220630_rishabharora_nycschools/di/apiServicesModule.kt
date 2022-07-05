package com.rishabh.a20220630_rishabharora_nycschools.di

import com.rishabh.a20220630_rishabharora_nycschools.data.api.APIService
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
