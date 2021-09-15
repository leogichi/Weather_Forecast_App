package com.weatherforecastapp.data.remote.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.weatherforecastapp.data.remote.WeatherApiConstants
import kotlinx.parcelize.Parcelize

@Parcelize
data class WeatherServer(
    @SerializedName(WeatherApiConstants.KEY_REQUEST_CODE) val id: String = "",
    @SerializedName(WeatherApiConstants.KEY_MESSAGE) val message: Long?= null,
    @SerializedName(WeatherApiConstants.KEY_CITIES_AROUND_NUMBER) val aroundMessage: Long?= null,
    @SerializedName(WeatherApiConstants.KEY_LIST) val list: List<ListServer>? = emptyList(),
    @SerializedName(WeatherApiConstants.KEY_CITY) val city: CityServer = CityServer(),
): Parcelable
