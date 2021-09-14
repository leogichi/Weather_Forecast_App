package com.weatherforecastapp.data.remote

object WeatherApiConstants {
    // Request
    const val KEY_CITY_QUERY = "q"
    const val KEY_UNIQUE_API = "appid"
    const val KEY_UNITS = "units"

    //Response
    const val KEY_REQUEST_CODE = "cod"
    const val KEY_MESSAGE = "message"
    const val KEY_CITIES_AROUND_NUMBER = "cnt"

    //LIST PART
    const val KEY_LIST = "list"
    const val KEY_DATA_TIME_CALCULATION = "dt"

    //MAIN PART
    const val KEY_MAIN = "main"
    const val KEY_TEMPERATURE = "temp"
    const val KEY_FEEL_LIKE = "feels_like"
    const val KEY_MIN_TEMP = "temp_min"
    const val KEY_MAX_TEMP = "temp_max"
    const val KEY_PRESSURE = "pressure"
    const val KEY_SEA_LEVEL = "sea_level"
    const val KEY_GRND_LEVEL = "grnd_level"
    const val KEY_HUMIDITY = "humidity"
    const val KEY_TEMP_KF = "temp_kf"

    //WEATHER PART
    const val KEY_WEATHER = "weather"
    const val KEY_ID = "id"
    const val KEY_DESCRIPTION = "description"
    const val KEY_ICON = "icon"

    // CLOUDS PART
    const val KEY_CLOUDS = "clouds"
    const val KEY_ALL = "all"

    // WIND PART
    const val KEY_WIND = "wind"
    const val KEY_SPEED = "speed"
    const val KEY_DEG = "deg"
    const val KEY_GUST = "gust"

    // VISIBILITY PART
    const val KEY_VISIBILITY = "visibility"
    const val KEY_POP = "pop"

    // RAIN PART
    const val KEY_RAIN = "rain"
    const val KEY_3H = "3h"

    // VISIBILITY SYS
    const val KEY_SYS = "sys"
    const val KEY_POD = "pod"

    // VISIBILITY DT_TXT
    const val KEY_DT_TXT = "dt_txt"

    // VISIBILITY CITY
    const val KEY_CITY = "city"
    const val KEY_NAME = "name"

    // VISIBILITY COORD
    const val KEY_COORD = "coord"
    const val KEY_LAT = "lat"
    const val KEY_LON = "lon"

    // VISIBILITY COUNTRY
    const val KEY_COUNTRY = "country"
    const val KEY_POPULATION = "population"
    const val KEY_TIMEZONE = "timezone"
    const val KEY_SUNRISE = "sunrise"
    const val KEY_SUNSET = "sunset"

}