package com.nels.master.androidpractices.data.remote.dto

import com.squareup.moshi.Json

data class Hourly(
    @field:Json(name = "pressure_msl")
    val pressures: List<Double>,
    @field:Json(name = "relativehumidity_2m")
    val relativehumidity: List<Int>,
    @field:Json(name = "temperature_2m")
    val temperature: List<Double>,
    @field:Json(name = "time")
    val time: List<String>,
    @field:Json(name = "weathercode")
    val weathercodes: List<Int>,
    @field:Json(name = "windspeed_10m")
    val windspeeds: List<Double>
)