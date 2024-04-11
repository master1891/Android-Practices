package com.nels.master.androidpractices.data.remote.dto

import com.squareup.moshi.Json

data class WeatherDto(

    @field:Json(name = "hourly")
    val hourlyData: Hourly,
    val hourly_units: HourlyUnits,
    val elevation: Int,
    val generationtime_ms: Double,
    val latitude: Double,
    val longitude: Double,
    val timezone: String,
    val timezone_abbreviation: String,
    val utc_offset_seconds: Int
)