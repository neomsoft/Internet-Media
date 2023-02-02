package io.neomsoft.internetmedia.data.entities

import io.neomsoft.internetmedia.R

enum class Weather(
    val shortTextRes: Int,
    val textRes: Int,
    val iconRes: Int,
) {
    CLOUDY(
        shortTextRes = R.string.weather_cloudy_short,
        textRes = R.string.weather_cloudy,
        iconRes = R.drawable.ic_weather_cloudy,
    ),
    SUNNY(
        shortTextRes = R.string.weather_sunny_short,
        textRes = R.string.weather_sunny,
        iconRes = R.drawable.ic_weather_sunny,
    ),
}