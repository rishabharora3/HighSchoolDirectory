package com.rishabh.a20220630_rishabharora_nycschools.di

import com.rishabh.a20220630_rishabharora_nycschools.ui.schoollist.SchoolListViewModel
import com.rishabh.a20220630_rishabharora_nycschools.ui.schooldetail.SchoolDetailViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 *  Koin Module for ViewModels
 */
val viewModelsModule = module {
    viewModel { SchoolListViewModel(get()) }
    viewModel { SchoolDetailViewModel(get()) }
}
