package co.cmedina.weather.domain

import co.cmedina.weather.data.model.CityWeatherResponse
import co.cmedina.weather.domain.model.CityWeather


fun CityWeatherResponse.toDomain() = CityWeather(
    temperature = this.current.tempC.toInt().toString(),
    condition = this.current.condition.text
)
