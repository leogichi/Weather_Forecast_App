package com.weatherforecastapp.data.remote.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.weatherforecastapp.data.remote.WeatherApiConstants
import kotlinx.parcelize.Parcelize

@Parcelize
data class MainServer(
    @SerializedName(WeatherApiConstants.KEY_TEMPERATURE) val temp: Double,
    @SerializedName(WeatherApiConstants.KEY_FEEL_LIKE) val feelsLike: Double,
    @SerializedName(WeatherApiConstants.KEY_MIN_TEMP) val tempMin: Double,
    @SerializedName(WeatherApiConstants.KEY_MAX_TEMP) val tempMax: Double,
    @SerializedName(WeatherApiConstants.KEY_PRESSURE) val pressure: Int?,
    @SerializedName(WeatherApiConstants.KEY_SEA_LEVEL) val seaLevel: Int?,
    @SerializedName(WeatherApiConstants.KEY_GRND_LEVEL) val grndLevel: Int?,
    @SerializedName(WeatherApiConstants.KEY_HUMIDITY) val humidity: Int?,
    @SerializedName(WeatherApiConstants.KEY_TEMP_KF) val tempKf: Double?
): Parcelable