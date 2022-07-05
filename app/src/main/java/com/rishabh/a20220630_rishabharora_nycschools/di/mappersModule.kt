package com.rishabh.a20220630_rishabharora_nycschools.di

import com.rishabh.a20220630_rishabharora_nycschools.data.models.mapper.SchoolListMapper
import com.rishabh.a20220630_rishabharora_nycschools.data.models.mapper.SchoolDetailMapper
import org.koin.dsl.module

/**
 * Module for mappers
 */
val mappersModule = module {
    single { SchoolListMapper() }
    single { SchoolDetailMapper() }
}
