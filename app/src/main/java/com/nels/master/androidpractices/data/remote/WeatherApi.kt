package com.nels.master.androidpractices.data.remote

import com.nels.master.androidpractices.data.remote.dto.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("v1/forecast?hourly=temperature_2m,weathercode,relativehumidity_2m,windspeed_10m,pressure_msl")
    suspend fun getWeather(
        @Query("latitude") latitude:Double,
        @Query("longitude") logintude:Double,
    ): WeatherDto

   companion object {
       val BASE_URL = " https://api.open-meteo.com/"
   }

}
