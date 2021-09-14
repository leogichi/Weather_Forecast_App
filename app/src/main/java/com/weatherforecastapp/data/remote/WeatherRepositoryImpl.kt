package com.weatherforecastapp.data.remote

import com.weatherforecastapp.BuildConfig
import com.weatherforecastapp.data.remote.models.WeatherServer
import com.weatherforecastapp.domain.repositories.WeatherRepository

class WeatherRepositoryImpl(
    private val weatherApi: WeatherApi
) : WeatherRepository {
    override suspend fun fetchWeather(cityName: String): WeatherServer? {
        return weatherApi.getWeather(cityName, BuildConfig.API_KEY, BuildConfig.API_UNITS)
    }

}