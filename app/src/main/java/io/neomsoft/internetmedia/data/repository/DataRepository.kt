package io.neomsoft.internetmedia.data.repository

import com.skydoves.sandwich.ApiResponse
import io.neomsoft.internetmedia.data.entities.Forecast
import io.neomsoft.internetmedia.data.entities.Response
import io.neomsoft.internetmedia.data.net.forecast.ForecastApi
import io.neomsoft.internetmedia.data.net.forecast.entities.ForecastResponse
import io.neomsoft.internetmedia.data.net.forecast.entities.ForecastResponse.Companion.toForecast
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class DataRepository(
    private val forecastApi: ForecastApi
): IDataRepository {
    override suspend fun getForecastByLocationNameForToday(
        locationName: String
    ): Flow<Response<Forecast>> = flow {
        emit(Response.Progress())

        val res = forecastApi.getForecastByLocationName(locationName)

        val value = if (res is ApiResponse.Success) {
            Response.Success(res.data.toForecast())
        } else when (res) {
            is ApiResponse.Failure.Exception -> Response.Error((res.exception))
            is ApiResponse.Failure.Error     -> Response.Error(HttpException(res.response))
            else                             -> Response.Error(RuntimeException())
        }

        emit(value)
    }
}