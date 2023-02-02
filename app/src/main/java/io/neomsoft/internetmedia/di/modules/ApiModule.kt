package io.neomsoft.internetmedia.di.modules

import io.neomsoft.internetmedia.data.net.forecast.ForecastApi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit

object ApiModule {

    val module = module {
        single {  ForecastApi.createApi(get()) }
    }
}