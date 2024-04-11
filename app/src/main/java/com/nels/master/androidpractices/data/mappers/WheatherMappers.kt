package com.nels.master.androidpractices.data.mappers

import android.os.Build
import androidx.annotation.RequiresApi
import com.nels.master.androidpractices.data.remote.dto.Hourly
import com.nels.master.androidpractices.data.remote.dto.WeatherDto
import com.nels.master.androidpractices.domain.weather.WeatherInfo
import com.nels.master.androidpractices.domain.weather.WeatherType
import com.nels.master.androidpractices.domain.weather.WheatherData
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class WheatherDataIndexed(
    val index:Int,
    val wheatherData: WheatherData
)

@RequiresApi(Build.VERSION_CODES.O)
fun Hourly.toWheatherDataMap():Map<Int, List<WheatherData>>{

    return time.mapIndexed { index, time ->

        val temp = this.temperature[index]
        val presure = this.pressures[index]
        val humidity = this.relativehumidity[index]
        val codeWeather = this.weathercodes[index]
        val windSpeed = this.windspeeds[index]


        WheatherDataIndexed(
            index = index,
            wheatherData = WheatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.BASIC_ISO_DATE),
                presure = presure,
                windSpeed = windSpeed,
                humidity = humidity.toDouble(),
                temperatureCelcius = temp,
                wheatherType = WeatherType.fromWMO(codeWeather)
            )
        )
    }.groupBy {
        it.index / 24
    }.mapValues {
        it.value.map {
            it.wheatherData
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDto.toWheatherInfo(): WeatherInfo {
    val wheatherDataMap = hourlyData.toWheatherDataMap()
    val now = LocalDateTime.now()
    val currentWeather = wheatherDataMap[0]?.find {
        val hour = if (now.minute < 30) now.hour else now.hour + 1
        it.time.hour == hour
    }
    return WeatherInfo(
        wheatherDataMap,
        currentWeather
    )
}