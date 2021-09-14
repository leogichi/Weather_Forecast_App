package com.weatherforecastapp.data.remote.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.weatherforecastapp.data.remote.WeatherApiConstants
import kotlinx.parcelize.Parcelize

@Parcelize
data class CityServer(
    @SerializedName(WeatherApiConstants.KEY_ID) val id: String?,
    @SerializedName(WeatherApiConstants.KEY_NAME) val name: String,
    @SerializedName(WeatherApiConstants.KEY_COORD) val coord: CoordServer?,
    @SerializedName(WeatherApiConstants.KEY_COUNTRY) val country: String?,
    @SerializedName(WeatherApiConstants.KEY_POPULATION) val population: Long?,
    @SerializedName(WeatherApiConstants.KEY_TIMEZONE) val timezone: Long?,
    @SerializedName(WeatherApiConstants.KEY_SUNRISE) val sunrise: Long?,
    @SerializedName(WeatherApiConstants.KEY_SUNSET) val sunset: Long?,
) : Parcelable