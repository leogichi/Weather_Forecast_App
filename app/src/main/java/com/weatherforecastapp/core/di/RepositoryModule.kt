package com.weatherforecastapp.core.di

import com.weatherforecastapp.data.remote.WeatherApi
import com.weatherforecastapp.data.remote.WeatherRepositoryImpl
import com.weatherforecastapp.domain.repositories.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun providesRandomRepository(weatherApi: WeatherApi): WeatherRepository =
        WeatherRepositoryImpl(weatherApi)
}