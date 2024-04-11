package com.nels.master.androidpractices.domain.repository

import com.nels.master.androidpractices.domain.util.Resource
import com.nels.master.androidpractices.domain.weather.WeatherInfo

interface WeatherRepositiry{
    suspend fun getWheatherData(lat:Double, long: Double): Resource<WeatherInfo>

}