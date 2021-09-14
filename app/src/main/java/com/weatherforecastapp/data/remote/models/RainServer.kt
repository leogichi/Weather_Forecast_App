package com.weatherforecastapp.data.remote.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.weatherforecastapp.data.remote.WeatherApiConstants
import kotlinx.parcelize.Parcelize

@Parcelize
data class RainServer(
    @SerializedName(WeatherApiConstants.KEY_3H) val threeH: Float?,
): Parcelable