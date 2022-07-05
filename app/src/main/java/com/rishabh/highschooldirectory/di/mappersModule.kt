package com.rishabh.highschooldirectory.di

import com.rishabh.highschooldirectory.data.models.mapper.SchoolListMapper
import com.rishabh.highschooldirectory.data.models.mapper.SchoolDetailMapper
import org.koin.dsl.module

/**
 * Module for mappers
 */
val mappersModule = module {
    single { SchoolListMapper() }
    single { SchoolDetailMapper() }
}
