package com.nels.master.androidpractices.domain.weather

data class WeatherInfo(
    val wheatherDataPerDay: Map<Int,List<WheatherData>>,
    val currentWheatherData: WheatherData?
)