package com.weatherforecastapp

import android.app.Application
import androidx.viewbinding.BuildConfig
import com.weatherforecastapp.app.ApplicationComponent
import com.weatherforecastapp.app.ApplicationModule
import com.weatherforecastapp.app.DaggerApplicationComponent
import timber.log.Timber

class WeatherForecastApp : Application() {

    override fun onCreate() {
        super.onCreate()
        component = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()

        if (BuildConfig.DEBUG) {
            Timber.plant((Timber.DebugTree()))
        }
    }
    companion object{
        private lateinit var component: ApplicationComponent

        fun getComponent() = component
    }
}