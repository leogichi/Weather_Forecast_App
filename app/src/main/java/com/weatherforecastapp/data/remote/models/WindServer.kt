package com.weatherforecastapp.data.remote.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.weatherforecastapp.data.remote.WeatherApiConstants
import kotlinx.parcelize.Parcelize

@Parcelize
data class WindServer(
    @SerializedName(WeatherApiConstants.KEY_SPEED) val speed: Float?,
    @SerializedName(WeatherApiConstants.KEY_DEG) val deg: Float?,
    @SerializedName(WeatherApiConstants.KEY_GUST) val gust: Float?,
) : Parcelable