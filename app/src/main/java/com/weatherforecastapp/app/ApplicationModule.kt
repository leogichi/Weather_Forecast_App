package com.weatherforecastapp.app

import android.app.Application
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ApplicationModule(private var application: Application) {

    @Provides
    @Singleton
    fun provideContext() = application


}