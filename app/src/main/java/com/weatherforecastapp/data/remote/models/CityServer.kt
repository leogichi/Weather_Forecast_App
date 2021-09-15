package com.weatherforecastapp.data.remote.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.weatherforecastapp.data.remote.WeatherApiConstants
import kotlinx.parcelize.Parcelize

@Parcelize
data class CityServer(
    @SerializedName(WeatherApiConstants.KEY_ID) val id: String? =null,
    @SerializedName(WeatherApiConstants.KEY_NAME) val name: String = "",
    @SerializedName(WeatherApiConstants.KEY_COORD) val coord: CoordServer? = null,
    @SerializedName(WeatherApiConstants.KEY_COUNTRY) val country: String? = null,
    @SerializedName(WeatherApiConstants.KEY_POPULATION) val population: Long? = null,
    @SerializedName(WeatherApiConstants.KEY_TIMEZONE) val timezone: Long? = null,
    @SerializedName(WeatherApiConstants.KEY_SUNRISE) val sunrise: Long? = null,
    @SerializedName(WeatherApiConstants.KEY_SUNSET) val sunset: Long? = null,
) : Parcelable