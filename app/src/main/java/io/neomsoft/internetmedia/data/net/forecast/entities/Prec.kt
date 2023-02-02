package io.neomsoft.internetmedia.data.net.forecast.entities

import com.google.gson.annotations.SerializedName

data class Prec(

    @SerializedName("class")
    val clazz: Double,

    val probability: Double,
    val sum: Double,
    val sumAsRain: Double
)