package io.neomsoft.internetmedia.data.repository

import io.neomsoft.internetmedia.data.entities.Forecast
import io.neomsoft.internetmedia.data.entities.Response
import kotlinx.coroutines.flow.Flow

interface IDataRepository {

    suspend fun getForecastByLocationNameForToday(locationName: String): Flow<Response<Forecast>>
}