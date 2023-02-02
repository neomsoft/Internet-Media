package io.neomsoft.internetmedia.di.modules

import io.neomsoft.internetmedia.ui.screens.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

object ViewModelsModule {

    val module = module {
        viewModelOf(::MainViewModel)
    }
}