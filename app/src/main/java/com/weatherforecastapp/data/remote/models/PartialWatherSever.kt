package com.weatherforecastapp.data.remote.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.weatherforecastapp.data.remote.WeatherApiConstants
import kotlinx.parcelize.Parcelize

@Parcelize
data class PartialWeatherServer(
    @SerializedName(WeatherApiConstants.KEY_ID) val id: String?,
    @SerializedName(WeatherApiConstants.KEY_MAIN) val main: String?,
    @SerializedName(WeatherApiConstants.KEY_DESCRIPTION) val description: String?,
    @SerializedName(WeatherApiConstants.KEY_ICON) val icon: String?,
): Parcelable