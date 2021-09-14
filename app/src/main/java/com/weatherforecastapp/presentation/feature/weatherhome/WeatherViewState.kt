package com.weatherforecastapp.presentation.feature.weatherhome

import com.weatherforecastapp.domain.models.WeatherView

sealed class WeatherViewState(
) {
    class Success(val data: List<WeatherView>?) : WeatherViewState()
    class Error(val message: String?) : WeatherViewState()
    class Loading : WeatherViewState()
}