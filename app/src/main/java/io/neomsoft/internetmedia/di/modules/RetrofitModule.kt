package io.neomsoft.internetmedia.di.modules

import io.neomsoft.internetmedia.data.net.base.RetrofitUtil
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

object RetrofitModule {

    val module = module {
        singleOf (::RetrofitUtil)
    }
}