package com.weatherforecastapp.data.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.weatherforecastapp.BuildConfig
import com.weatherforecastapp.data.remote.models.*
import com.weatherforecastapp.domain.repositories.WeatherRepository
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test

class WeatherRepositoryImplTest{
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    val weatherRepository: WeatherRepository
    val weatherApi:WeatherApi = mock()
    init {
        weatherRepository = WeatherRepositoryImpl(weatherApi)
    }

    @Test
    fun `given api uses to fetchWeather() with cityname correctly , then return response sucessful with WeatherServer data  and code 200`()=
        runBlocking{
            val mainServer = MainServer(35.0,35.10,34.9,36.0,100,1000,0,1,null)
            val partialWeatherList =  listOf(PartialWeatherServer(null,null,null,null))
            val listServer = ListServer(1L, mainServer, partialWeatherList,null,null,null,null,null,null,null)
            val weatherServer = WeatherServer(id="200",list= listOf(listServer),city = CityServer(name = "Xalapa"))

            whenever(weatherApi.getWeather("Xalapa",BuildConfig.API_KEY,BuildConfig.API_UNITS)).thenReturn(weatherServer)
            val weatherResponse = weatherRepository.fetchWeather("Xalapa")
            assertThat(weatherResponse?.id.contentEquals("200")).isTrue()
            assertThat(weatherResponse?.city?.name.contentEquals("Xalapa")).isTrue()

        }


    }



