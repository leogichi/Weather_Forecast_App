package com.weatherforecastapp.core.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.weatherforecastapp.presentation.feature.weatherhome.viewmodel.ViewModelFactory
import com.weatherforecastapp.presentation.feature.weatherhome.viewmodel.WeatherViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(WeatherViewModel::class)
    abstract  fun weatherViewModel(viewModel : WeatherViewModel):ViewModel
}