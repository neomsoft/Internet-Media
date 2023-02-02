package io.neomsoft.internetmedia.data.entities

data class Forecast(
    val code: String,
    val cityName: String,
    val weather: Weather,
    val temperature: Double,
)