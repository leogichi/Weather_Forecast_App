package com.weatherforecastapp.data.remote.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.weatherforecastapp.data.remote.WeatherApiConstants
import kotlinx.parcelize.Parcelize

@Parcelize
data class CoordServer(
    @SerializedName(WeatherApiConstants.KEY_LAT) val lat: Double?,
    @SerializedName(WeatherApiConstants.KEY_LON) val lon: Double?
) : Parcelable