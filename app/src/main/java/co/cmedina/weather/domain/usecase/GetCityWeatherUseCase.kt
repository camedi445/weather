package co.cmedina.weather.domain.usecase

import co.cmedina.weather.domain.repository.CityRepository
import javax.inject.Inject

class GetCityWeatherUseCase @Inject constructor(
    private val cityRepository: CityRepository
) {
    suspend operator fun invoke(cityName: String) = cityRepository.getCityWeather(cityName)
}