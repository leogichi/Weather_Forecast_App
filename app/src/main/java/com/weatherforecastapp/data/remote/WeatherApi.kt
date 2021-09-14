package com.weatherforecastapp.data.remote

import com.weatherforecastapp.data.remote.models.WeatherServer
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("forecast")
    suspend fun getWeather(
        @Query(WeatherApiConstants.KEY_CITY_QUERY) strCityName: String,
        @Query(WeatherApiConstants.KEY_UNIQUE_API) strUniqueApiKey: String,
        @Query(WeatherApiConstants.KEY_UNITS) strUnits: String
    ): WeatherServer?
}