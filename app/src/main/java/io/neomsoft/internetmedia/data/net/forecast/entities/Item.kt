package io.neomsoft.internetmedia.data.net.forecast.entities

import com.google.gson.annotations.SerializedName
import java.util.Date

data class Item(
    val astronomy: Astronomy,

    @SerializedName("dateWithTimezone")
    val date: Date,

    val freshSnow: Double,
    val prec: Prec,
    val rainHours: Double? = null,
    val snowHeight: Double? = null,
    val snowLine: SnowLine? = null,
    val sunHours: Double? = null,
    val temperature: Temperature,
    val weather: Weather,
    val wind: Wind,
    val windchill: Windchill
)