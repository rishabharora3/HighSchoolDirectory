package com.rishabh.a20220630_rishabharora_nycschools.di

import com.rishabh.a20220630_rishabharora_nycschools.data.repository.SchoolListRepository
import com.rishabh.a20220630_rishabharora_nycschools.data.repository.SchoolRepositoryImpl
import com.rishabh.a20220630_rishabharora_nycschools.data.repository.SchoolDetailRepository
import com.rishabh.a20220630_rishabharora_nycschools.data.repository.SchoolDetailRepositoryImpl
import org.koin.dsl.module

/**
 *  DI module for Repository
 */
val repoModule = module {
    single<SchoolListRepository> { SchoolRepositoryImpl(get(), get()) }
    single<SchoolDetailRepository> { SchoolDetailRepositoryImpl(get(), get()) }
}
