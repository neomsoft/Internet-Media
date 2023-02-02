package io.neomsoft.internetmedia.data.net.forecast.entities

import com.google.gson.annotations.SerializedName

data class Astronomy(
    val dawn: String,
    val dusk: String,

    @SerializedName("moonphase")
    val moonPhase: Int,
    val moonrise: String,

    @SerializedName("moonset")
    val moonSet: String,

    @SerializedName("moontransit")
    val moonTransit: String,

    @SerializedName("moonzodiac")
    val moonZodiac: Int,

    val sunrise: String,
    val sunset: String,

    @SerializedName("suntransit")
    val sunTransit: String
)