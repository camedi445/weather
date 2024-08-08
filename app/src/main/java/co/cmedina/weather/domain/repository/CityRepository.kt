package co.cmedina.weather.domain.repository

import co.cmedina.weather.domain.model.City
import co.cmedina.weather.domain.model.CityWeather

interface CityRepository {


    suspend fun getCityByName(cityName: String): List<City>

    suspend fun getCityWeather(cityName: String): CityWeather
}