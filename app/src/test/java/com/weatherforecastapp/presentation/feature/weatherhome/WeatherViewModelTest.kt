package com.weatherforecastapp.presentation.feature.weatherhome

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.MockitoKotlinException
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.weatherforecastapp.data.remote.models.*
import com.weatherforecastapp.domain.repositories.WeatherRepository
import com.weatherforecastapp.presentation.feature.weatherhome.viewmodel.WeatherViewModel
import com.weatherforecastapp.utils.getOrAwaitValueTest
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import java.lang.Exception


class WeatherViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val viewModel: WeatherViewModel
    private val repository :WeatherRepository = mock()

    init {
        viewModel = WeatherViewModel(repository)
    }

    @Test
    fun `given repository returns response successful ,then viewstate updates with weather data`() = runBlocking {
        val mainServer = MainServer(35.0,35.10,34.9,36.0,100,1000,0,1,null)
        val partialWeatherList =  listOf(PartialWeatherServer(null,null,null,null))
        val listServer = ListServer(1L, mainServer, partialWeatherList,null,null,null,null,null,null,null)
        val weatherResponse = WeatherServer(id="123",list= listOf(listServer),city = CityServer(name = "CityTest"))
        whenever(repository.fetchWeather(any())).thenReturn(weatherResponse)

        viewModel.getWeather("CityTest")

        val viewStateLoading = viewModel.data.getOrAwaitValueTest()
        assertThat(viewStateLoading).isInstanceOf(WeatherViewState.Loading::class.java)

        val viewState = viewModel.data.getOrAwaitValueTest()
        assertThat(viewState).isInstanceOf(WeatherViewState.Success::class.java)
        val cityName = (viewState as WeatherViewState.Success).data?.get(0)?.cityName
        assertThat(cityName.contentEquals("CityTest")).isTrue()
    }

    @Test
    fun `given repository returns exception ,then viewstate updates with error`() = runBlocking {
        whenever(repository.fetchWeather(any())).thenThrow(MockitoKotlinException("Error simulator",Exception()))
        viewModel.getWeather("CityTest")
        val viewStateLoading = viewModel.data.getOrAwaitValueTest()
        assertThat(viewStateLoading).isInstanceOf(WeatherViewState.Loading::class.java)

        val viewState = viewModel.data.getOrAwaitValueTest()
        assertThat(viewState).isInstanceOf(WeatherViewState.Error::class.java)


    }

    @Test
    fun `when resetData(), then viewstate value is null `(){
        viewModel.resetData()
        val viewState = viewModel.data.getOrAwaitValueTest()
        assertThat(viewState).isNull()
    }
}