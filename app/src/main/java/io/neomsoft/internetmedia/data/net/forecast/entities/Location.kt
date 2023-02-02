package io.neomsoft.internetmedia.data.net.forecast.entities

data class Location(
    val code: String,
    val coordinates: Coordinates,
    val name: String,
    val timezone: String
)