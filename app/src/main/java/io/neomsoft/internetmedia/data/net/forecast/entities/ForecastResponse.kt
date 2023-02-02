package io.neomsoft.internetmedia.data.net.forecast.entities

import io.neomsoft.internetmedia.data.entities.Weather
import io.neomsoft.internetmedia.data.entities.Forecast as MainForecast

data class ForecastResponse(
    val location: Location,
    val forecast: Forecast,
) {

    companion object {
        fun ForecastResponse.toForecast() = MainForecast(
            code = location.code,
            cityName = location.name,
            weather = Weather.CLOUDY,
            temperature = 5.0,
        )
    }
}