package io.neomsoft.internetmedia.ui.screens.main

import io.neomsoft.internetmedia.data.entities.Forecast

data class MainState(
    val state: State = State.NONE,
    val canSearchNewWeather: Boolean,
    val locationName: String,
    val forecast: Forecast? = null,
) {

    enum class State {
        NONE, SUCCESS, ERROR, PROGRESS
    }

    companion object {
        val EMPTY = MainState(
            canSearchNewWeather = false,
            locationName = "",
        )
    }
}
