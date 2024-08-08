package co.cmedina.weather.data.mapper

import co.cmedina.weather.data.model.CityWeatherResponse
import co.cmedina.weather.domain.model.CityWeather
import co.cmedina.weather.domain.model.Day
import co.cmedina.weather.util.ensureHttps
import co.cmedina.weather.util.extractDate
import co.cmedina.weather.util.extractTime


fun CityWeatherResponse.toDomain() = CityWeather(
    temperature = this.current.tempC.toInt().toString(),
    condition = this.current.condition.text,
    localTime = this.location.localtime.extractDate(),
    hour = this.location.localtime.extractTime(),
    conditionIconUrl = this.current.condition.icon.ensureHttps(),
    humidity = this.current.humidity.toString(),
    wind = this.current.windDegree.toString(),
    pressure = this.current.pressureIn.toString(),
    visibility = this.current.cloud.toString(),
    days = this.forecast.forecastday.map {
        Day(
            temperature = it.day.avgTempC.toString(),
            condition = it.day.condition.text,
            iconUrl = it.day.condition.icon.ensureHttps()
        )
    }
)
