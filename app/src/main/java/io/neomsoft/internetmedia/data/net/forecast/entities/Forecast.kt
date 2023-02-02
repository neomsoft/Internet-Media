package io.neomsoft.internetmedia.data.net.forecast.entities

import java.util.Date

data class Forecast(
    val items: List<Item>,
    val forecastDate: Date,
    val nextUpdate: Date,
    val point: String,
    val source: String,
    val fingerprint: String? = null,
)