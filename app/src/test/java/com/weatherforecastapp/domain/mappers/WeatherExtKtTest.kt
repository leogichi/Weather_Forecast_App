package com.weatherforecastapp.domain.mappers

import com.google.common.truth.Truth.assertThat
import com.google.common.truth.Truth.assertWithMessage
import com.weatherforecastapp.data.remote.models.*

import org.junit.Test

class WeatherExtKtTest {

    @Test
    fun `convert ServerList To WeatherView,then verify fields matches correctly`() {
        val mainServer = MainServer(35.0,35.10,34.9,36.0,100,1000,0,1,null)
        val partialWeatherList =  listOf(PartialWeatherServer(null,null,"TestDescription",null))
        val listServer = ListServer(1L, mainServer, partialWeatherList,null,null,null,null,null,null,null)
        val weatherResponse = WeatherServer(id="123",list= listOf(listServer),city = CityServer(name = "CityTest"))
        val weatherView = weatherResponse.list?.get(0)?.mapToDomain("CityTest")

        //Match and validate Fields

        assertThat(weatherView?.timeStamp?.equals(1L)).isTrue()
        assertThat(weatherView?.cityName?.contentEquals("CityTest")).isTrue()
        assertThat(weatherView?.feelsLikeTemp?.equals(35.10)).isTrue()
        assertThat(weatherView?.minTemp?.equals(34.9)).isTrue()
        assertThat(weatherView?.maxTemp?.equals(36.0)).isTrue()
        assertThat(weatherView?.weatherName?.isNullOrEmpty())
        assertThat(weatherView?.weatherDescription.equals("TestDescription")).isTrue()

    }
}