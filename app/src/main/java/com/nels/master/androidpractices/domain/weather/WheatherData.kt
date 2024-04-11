package com.nels.master.androidpractices.domain.weather

import java.time.LocalDateTime

data class WheatherData(
    val time: LocalDateTime,
    val temperatureCelcius:Double,
    val presure: Double,
    val windSpeed:Double,
    val humidity: Double,
    val wheatherType: WeatherType
)