package com.nels.master.androidpractices.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.nels.master.androidpractices.data.mappers.toWheatherDataMap
import com.nels.master.androidpractices.data.mappers.toWheatherInfo
import com.nels.master.androidpractices.data.remote.WeatherApi
import com.nels.master.androidpractices.domain.repository.WeatherRepositiry
import com.nels.master.androidpractices.domain.util.Resource
import com.nels.master.androidpractices.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepositiry {

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWheatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            val response = api.getWeather(latitude = lat, logintude = long)
            Resource.Success(response.toWheatherInfo())
        }catch (ex : Exception){
            Resource.Error(ex.message?: "nada")
        }
    }

}