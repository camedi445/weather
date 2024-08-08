package co.cmedina.weather.data.repository

import co.cmedina.weather.BuildConfig
import co.cmedina.weather.data.api.WeatherApi
import co.cmedina.weather.domain.model.City
import co.cmedina.weather.domain.model.CityWeather
import co.cmedina.weather.domain.repository.CityRepository
import co.cmedina.weather.data.mapper.toDomain

class CityRepositoryImpl(
    private val weatherApi: WeatherApi
) : CityRepository {

    override suspend fun getCityByName(cityName: String): List<City> {
        return weatherApi.fetchCityByName(cityName = cityName, key = BuildConfig.API_KEY)
            .map { it.toDomainCity() }
    }

    override suspend fun getCityWeather(cityName: String): CityWeather {
        val apiResponse =
            weatherApi.fetchCityWeather(cityName = cityName, key = BuildConfig.API_KEY, days = DAYS)
        return apiResponse.toDomain()
    }
}

private const val DAYS = "7"
