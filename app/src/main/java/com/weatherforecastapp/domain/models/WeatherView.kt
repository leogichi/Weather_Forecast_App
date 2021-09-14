package com.weatherforecastapp.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WeatherView(
    val timeStamp: Long = 0L,
    val cityName: String = "",
    val temp: Double = 0.0,
    val minTemp: Double = 0.0,
    val maxTemp: Double = 0.0,
    val feelsLikeTemp: Double = 0.0,
    val weatherName: String = "",
    val weatherDescription: String = ""
) : Parcelable