package io.neomsoft.internetmedia.data.net.base

import com.skydoves.sandwich.coroutines.CoroutinesResponseCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitUtil {

    private val loggingInterceptor = HttpLoggingInterceptor()
        .apply { level = HttpLoggingInterceptor.Level.BODY }

    fun getClientBuilder() = OkHttpClient
        .Builder()
        .readTimeout(READ_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
        .writeTimeout(WRITE_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
        .connectTimeout(CONNECT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor)

    fun getRetrofitBuilder(
        baseUrl: String,
        client: OkHttpClient = getClientBuilder().build(),
        converterFactory: Converter.Factory = GsonConverterFactory.create(),
        callAdapterFactory: CallAdapter.Factory = CoroutinesResponseCallAdapterFactory.create()
    ) = Retrofit
        .Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addConverterFactory(converterFactory)
        .addCallAdapterFactory(callAdapterFactory)

    companion object {

        private const val READ_TIMEOUT_IN_SECONDS = 60L
        private const val WRITE_TIMEOUT_IN_SECONDS = 60L
        private const val CONNECT_TIMEOUT_IN_SECONDS = 60L
    }
}