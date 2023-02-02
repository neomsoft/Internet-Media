package io.neomsoft.internetmedia.data.net.forecast.entities

data class Wind(
    val avg: Double? = null,
    val direction: String,
    val gusts: Gusts,
    val max: Double? = null,
    val min: Double? = null,
    val significationWind: Boolean,
    val text: String,
    val unit: String
)