package com.weatherforecastapp.domain.repositories

import com.weatherforecastapp.data.remote.models.WeatherServer

interface WeatherRepository {
    suspend fun fetchWeather(cityName:String): WeatherServer?
}