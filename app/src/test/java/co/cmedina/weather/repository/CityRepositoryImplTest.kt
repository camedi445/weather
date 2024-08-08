package co.cmedina.weather.repository

import arrow.core.Either
import co.cmedina.weather.data.api.WeatherApi
import co.cmedina.weather.data.mapper.toDomain
import co.cmedina.weather.data.model.CityDto
import co.cmedina.weather.data.model.CityWeatherResponse
import co.cmedina.weather.data.repository.CityRepositoryImpl
import co.cmedina.weather.domain.repository.CityRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class CityRepositoryImplTest {

    private lateinit var weatherApi: WeatherApi
    private lateinit var cityRepository: CityRepository

    @Before
    fun setUp() {
        weatherApi = mockk()
        cityRepository = CityRepositoryImpl(weatherApi)
        mockkStatic("co.cmedina.weather.data.mapper.CityWeatherApiMapperKt")
    }

    @Test
    fun `getCityByName should return Right with a list of City when API call is successful`() =
        runTest {
            val cityName = "London"
            val city = mockk<CityDto>(relaxed = true) {
                every { toDomainCity() } returns mockk(relaxed = true)
            }
            val cityDtoList = listOf(city)
            coEvery {
                weatherApi.fetchCityByName(
                    cityName = cityName,
                    key = any()
                )
            } returns cityDtoList
            val result = cityRepository.getCityByName(cityName)
            coVerify { weatherApi.fetchCityByName(cityName = cityName, key = any()) }
            assertTrue(result is Either.Right)
        }

    @Test
    fun `getCityByName should return Left with MessageException when API call fails`() =
        runTest {
            val cityName = "London"
            val exception = Exception("Network error")
            coEvery {
                weatherApi.fetchCityByName(
                    cityName = cityName,
                    key = any()
                )
            } throws exception
            val result = cityRepository.getCityByName(cityName)
            coVerify { weatherApi.fetchCityByName(cityName = cityName, key = any()) }
            assertTrue(result is Either.Left)
        }

    @Test
    fun `getCityWeather should return Right with CityWeather when API call is successful`() =
        runTest {
            val cityName = "London"
            val cityWeatherDto = mockk<CityWeatherResponse>(relaxed = true) {
                every { toDomain() } returns mockk(relaxed = true)
            }
            coEvery {
                weatherApi.fetchCityWeather(
                    cityName = cityName, days = any(), key = any()
                )
            } returns cityWeatherDto
            val result = cityRepository.getCityWeather(cityName)
            coVerify { weatherApi.fetchCityWeather(cityName = cityName, days = any(), key = any()) }
            assertTrue(result is Either.Right)
        }

    @Test
    fun `getCityWeather should return Left with MessageException when API call fails`() =
        runTest {
            val cityName = "London"
            val exception = Exception("Network error")
            coEvery {
                weatherApi.fetchCityWeather(
                    cityName = cityName, days = any(), key = any()
                )
            } throws exception
            val result = cityRepository.getCityWeather(cityName)
            coVerify { weatherApi.fetchCityWeather(cityName = cityName, days = any(), key = any()) }
            assertTrue(result is Either.Left)
        }
}