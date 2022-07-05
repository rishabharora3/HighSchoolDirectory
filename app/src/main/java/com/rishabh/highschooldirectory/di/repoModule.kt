package com.rishabh.highschooldirectory.di

import com.rishabh.highschooldirectory.data.repository.SchoolListRepository
import com.rishabh.highschooldirectory.data.repository.SchoolRepositoryImpl
import com.rishabh.highschooldirectory.data.repository.SchoolDetailRepository
import com.rishabh.highschooldirectory.data.repository.SchoolDetailRepositoryImpl
import org.koin.dsl.module

/**
 *  DI module for Repository
 */
val repoModule = module {
    single<SchoolListRepository> { SchoolRepositoryImpl(get(), get()) }
    single<SchoolDetailRepository> { SchoolDetailRepositoryImpl(get(), get()) }
}
