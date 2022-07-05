package com.rishabh.a20220630_rishabharora_nycschools

import android.app.Application
import com.rishabh.a20220630_rishabharora_nycschools.di.apiServicesModule
import com.rishabh.a20220630_rishabharora_nycschools.di.appModule
import com.rishabh.a20220630_rishabharora_nycschools.di.mappersModule
import com.rishabh.a20220630_rishabharora_nycschools.di.networkModule
import com.rishabh.a20220630_rishabharora_nycschools.di.repoModule
import com.rishabh.a20220630_rishabharora_nycschools.di.viewModelsModule
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