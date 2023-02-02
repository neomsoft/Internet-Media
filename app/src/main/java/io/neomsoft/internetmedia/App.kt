package io.neomsoft.internetmedia

import android.app.Application
import io.neomsoft.internetmedia.di.Koin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        Koin.initialize(this)
    }
}