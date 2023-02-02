package io.neomsoft.internetmedia.di

import android.app.Application
import io.neomsoft.internetmedia.di.modules.ApiModule
import io.neomsoft.internetmedia.di.modules.RepositoryModule
import io.neomsoft.internetmedia.di.modules.RetrofitModule
import io.neomsoft.internetmedia.di.modules.ViewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

object Koin {

    fun initialize(application: Application) {
        startKoin {
            androidLogger()
            androidContext(application)

            modules(
                RetrofitModule.module,
                ApiModule.module,
                RepositoryModule.module,
                ViewModelsModule.module,
            )
        }
    }
}