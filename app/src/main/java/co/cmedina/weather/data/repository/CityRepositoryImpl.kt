package co.cmedina.weather.data.repository

import arrow.core.Either
import co.cmedina.weather.BuildConfig
import co.cmedina.weather.data.api.WeatherApi
import co.cmedina.weather.domain.model.City
import co.cmedina.weather.domain.model.CityWeather
import co.cmedina.weather.domain.repository.CityRepository
import co.cmedina.weather.data.mapper.toDomain
import co.cmedina.weather.domain.exception.MessageException

class CityRepositoryImpl(
    private val weatherApi: WeatherApi
) : CityRepository {

    override suspend fun getCityByName(cityName: String): Either<MessageException, List<City>> {
        return try {
            Either.Right(weatherApi.fetchCityByName(
                cityName = cityName,
                key = BuildConfig.API_KEY
            ).map { it.toDomainCity() })
        } catch (exception: Exception) {
            Either.Left(MessageException(GENERAL_ERROR_MESSAGE))
        }
    }

    override suspend fun getCityWeather(cityName: String): Either<MessageException, CityWeather> {
        return try {
            val apiResponse =
                weatherApi.fetchCityWeather(
                    cityName = cityName,
                    key = BuildConfig.API_KEY,
                    days = DAYS
                )
            Either.Right(apiResponse.toDomain())
        } catch (exception: Exception) {
            Either.Left(MessageException(GENERAL_ERROR_MESSAGE))
        }
    }
}

private const val DAYS = "7"
private const val GENERAL_ERROR_MESSAGE = "Ha ocurrido un error, intenta nuevamente."
