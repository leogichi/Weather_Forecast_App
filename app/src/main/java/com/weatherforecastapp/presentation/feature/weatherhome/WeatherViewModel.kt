package com.weatherforecastapp.presentation.feature.weatherhome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weatherforecastapp.domain.mappers.mapToDomain
import com.weatherforecastapp.domain.repositories.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {
    private var _data = MutableLiveData<WeatherViewState?>()
    val data: LiveData<WeatherViewState?> get() = _data

    fun getWeather(cityName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _data.postValue(WeatherViewState.Loading())

            try {
                val response = repository.fetchWeather(cityName)

                val weatherList = response?.list?.map { it.mapToDomain(response.city.name) }
                _data.postValue(WeatherViewState.Success(weatherList))

            } catch (e: Exception) {
                _data.postValue(WeatherViewState.Error(e.toString()))
            }
        }
    }

    fun resetData() {
        _data.postValue(null)
    }
}