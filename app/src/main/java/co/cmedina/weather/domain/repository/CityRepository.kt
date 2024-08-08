package co.cmedina.weather.domain.repository

import arrow.core.Either
import co.cmedina.weather.domain.exception.MessageException
import co.cmedina.weather.domain.model.City
import co.cmedina.weather.domain.model.CityWeather

interface CityRepository {


    suspend fun getCityByName(cityName: String): Either<MessageException, List<City>>

    suspend fun getCityWeather(cityName: String): Either<MessageException, CityWeather>
}