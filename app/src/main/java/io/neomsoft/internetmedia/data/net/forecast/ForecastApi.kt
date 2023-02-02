package io.neomsoft.internetmedia.data.net.forecast

import com.google.gson.GsonBuilder
import com.skydoves.sandwich.ApiResponse
import io.neomsoft.internetmedia.data.net.base.RetrofitUtil
import io.neomsoft.internetmedia.data.net.forecast.entities.Forecast
import io.neomsoft.internetmedia.data.net.forecast.entities.ForecastResponse
import okhttp3.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ForecastApi {

    @GET("forecast/{locationName}/summary/")
    suspend fun getForecastByLocationName(
        @Path("locationName")
        locationName: String
    ): ApiResponse<ForecastResponse>

    @GET("forecast/{latitude}/{longitude}/summary/")
    suspend fun getForecastByCoordinates(
        @Path("longitude")
        longitude: Float,

        @Path("latitude")
        latitude: Float,
    ): ApiResponse<Forecast>

    companion object {

        private const val BASE_URL = "https://forecast9.p.rapidapi.com/rapidapi/"
        private const val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"

        fun createApi(retrofitUtil: RetrofitUtil): ForecastApi {
            val gson = GsonBuilder()
                .setDateFormat(DATE_FORMAT)
                .create()

            val authenticator = Authenticator { _, response -> response
                .request
                .newBuilder()
                // *
                .header("X-RapidAPI-Key", "6bab090bdemshcc64d40dbe7cc59p11e913jsnd59790c3fdca")
                .header("X-RapidAPI-Host", "forecast9.p.rapidapi.com")
                .build()
            }

            val client = retrofitUtil
                .getClientBuilder()
                .authenticator(authenticator)
                .build()

            return retrofitUtil
                .getRetrofitBuilder(
                    baseUrl = BASE_URL,
                    client = client,
                    converterFactory = GsonConverterFactory.create(gson),
                )
                .build()
                .create(ForecastApi::class.java)
        }
    }
}