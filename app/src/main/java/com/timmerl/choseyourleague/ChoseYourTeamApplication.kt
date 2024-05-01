package com.timmerl.choseyourleague

import android.app.Application
import com.timmerl.choseyourleague.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ChoseYourTeamApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ChoseYourTeamApplication)
            modules(appModule)
        }
    }
}