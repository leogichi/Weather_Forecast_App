package com.weatherforecastapp.domain.mappers

import com.weatherforecastapp.data.remote.models.ListServer
import com.weatherforecastapp.domain.models.WeatherView

fun ListServer.mapToDomain(city: String): WeatherView = WeatherView(
    timeStamp = dataTimeCalculaiton,
    cityName = city,
    temp = main.temp,
    minTemp = main.tempMin,
    maxTemp = main.tempMax,
    feelsLikeTemp = main.feelsLike,
    weatherName = weather.firstOrNull()?.main ?: "",
    weatherDescription = weather.firstOrNull()?.description ?: ""
)