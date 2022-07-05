package com.rishabh.highschooldirectory.di

import com.rishabh.highschooldirectory.ui.schoollist.SchoolListViewModel
import com.rishabh.highschooldirectory.ui.schooldetail.SchoolDetailViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 *  Koin Module for ViewModels
 */
val viewModelsModule = module {
    viewModel { SchoolListViewModel(get()) }
    viewModel { SchoolDetailViewModel(get()) }
}
