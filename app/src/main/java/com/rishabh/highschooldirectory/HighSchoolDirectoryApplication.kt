package com.rishabh.highschooldirectory

import android.app.Application
import com.rishabh.highschooldirectory.di.apiServicesModule
import com.rishabh.highschooldirectory.di.appModule
import com.rishabh.highschooldirectory.di.mappersModule
import com.rishabh.highschooldirectory.di.networkModule
import com.rishabh.highschooldirectory.di.repoModule
import com.rishabh.highschooldirectory.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 *  Application class for the app
 */
class HighSchoolDirectoryApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@HighSchoolDirectoryApplication)
            modules(appModule, networkModule, repoModule, apiServicesModule, viewModelsModule, mappersModule)
        }
    }
}