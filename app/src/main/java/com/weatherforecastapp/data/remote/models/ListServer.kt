package com.weatherforecastapp.data.remote.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.weatherforecastapp.data.remote.WeatherApiConstants
import kotlinx.parcelize.Parcelize

@Parcelize
data class ListServer(
    @SerializedName(WeatherApiConstants.KEY_DATA_TIME_CALCULATION) val dataTimeCalculaiton: Long,
    @SerializedName(WeatherApiConstants.KEY_MAIN) val main: MainServer,
    @SerializedName(WeatherApiConstants.KEY_WEATHER) val weather: List<PartialWeatherServer>,
    @SerializedName(WeatherApiConstants.KEY_CLOUDS) val clouds: CloudsServer?,
    @SerializedName(WeatherApiConstants.KEY_WIND) val wind: WindServer?,
    @SerializedName(WeatherApiConstants.KEY_VISIBILITY) val visibility: Long?,
    @SerializedName(WeatherApiConstants.KEY_POP) val pop: Float?,
    @SerializedName(WeatherApiConstants.KEY_RAIN) val rain: RainServer?,
    @SerializedName(WeatherApiConstants.KEY_SYS) val sys: SysServer?,
    @SerializedName(WeatherApiConstants.KEY_DT_TXT) val dtText: String?

): Parcelable