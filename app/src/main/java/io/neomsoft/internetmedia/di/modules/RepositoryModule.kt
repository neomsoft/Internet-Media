package io.neomsoft.internetmedia.di.modules

import io.neomsoft.internetmedia.data.repository.IDataRepository
import io.neomsoft.internetmedia.data.repository.DataRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

object RepositoryModule {

    val module = module {
        singleOf(::DataRepository) { bind<IDataRepository>() }
    }
}