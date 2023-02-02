package io.neomsoft.internetmedia.ui.screens.main

import io.neomsoft.internetmedia.data.entities.Response
import io.neomsoft.internetmedia.data.repository.IDataRepository
import io.neomsoft.internetmedia.ui.base.BaseViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModel(
    private val repository: IDataRepository
): BaseViewModel() {

    private val btnClickFlow = MutableStateFlow("")
    private val locationNameFlow = MutableStateFlow("")

    private val forecastFlow = btnClickFlow
        .filter { it.length > 2 }
        .flatMapLatest { repository.getForecastByLocationNameForToday(it) }
        .stateIn(Response.None())

    val stateFlow = locationNameFlow
        .combine(forecastFlow) { locationName, forecastResponse ->
            val state = when (forecastResponse) {
                is Response.None -> MainState.State.NONE
                is Response.Error -> MainState.State.ERROR
                is Response.Progress -> MainState.State.PROGRESS
                is Response.Success -> MainState.State.SUCCESS
            }

            val forecast = if (forecastResponse is Response.Success)
                forecastResponse.data
            else
                null

            val canSearchNewWeather = locationName.length > 2 && state != MainState.State.PROGRESS

            MainState(
                state = state,
                canSearchNewWeather = canSearchNewWeather,
                locationName = locationName,
                forecast = forecast
            )
        }
        .stateIn(MainState.EMPTY)

    fun onLocationNameChanged(locationName: String) {
        locationNameFlow.value = locationName
    }

    fun onBtnGetForecastClick(locationName: String) {
        btnClickFlow.value = locationName
    }
}