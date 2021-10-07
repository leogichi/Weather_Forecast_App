package com.weatherforecastapp.app

import com.weatherforecastapp.core.di.NetworkModule
import com.weatherforecastapp.core.di.RepositoryModule
import com.weatherforecastapp.core.di.ViewModelModule
import com.weatherforecastapp.presentation.feature.weatherhome.ui.HomeFragment
import com.weatherforecastapp.presentation.feature.weatherhome.viewmodel.ViewModelFactory
import com.weatherforecastapp.presentation.feature.weatherhome.viewmodel.WeatherViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class,
    ViewModelModule::class,
    RepositoryModule::class,
    NetworkModule::class
])

interface ApplicationComponent {
    fun inject(target: HomeFragment)

}

