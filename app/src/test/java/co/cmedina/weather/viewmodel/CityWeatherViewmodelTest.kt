package co.cmedina.weather.viewmodel

import arrow.core.Either
import co.cmedina.weather.domain.exception.MessageException
import co.cmedina.weather.domain.model.CityWeather
import co.cmedina.weather.domain.usecase.GetCityWeatherUseCase
import co.cmedina.weather.rule.MainCoroutineRule
import co.cmedina.weather.ui.city.state.CityState
import co.cmedina.weather.ui.city.viewmodel.CityWeatherViewmodel
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CityWeatherViewmodelTest {

    private val dispatcher = UnconfinedTestDispatcher()

    @get:Rule
    val coroutineRule = MainCoroutineRule(dispatcher)

    private lateinit var viewModel: CityWeatherViewmodel
    private val getCityWeatherUseCase: GetCityWeatherUseCase = mockk()

    @Before
    fun setUp() {
        viewModel = CityWeatherViewmodel(
            getCityWeatherUseCase = getCityWeatherUseCase,
            dispatcher = dispatcher
        )
    }

    @Test
    fun `getCityWeather should update state with city weather on success`() = runTest {
        val cityName = "Medellín"
        val expectedWeather = mockk<CityWeather>()
        val result = Either.Right(expectedWeather)
        coEvery { getCityWeatherUseCase.invoke(cityName) } returns result
        viewModel.getCityWeather(cityName)
        assertEquals(
            CityState(isLoading = false, cityWeather = expectedWeather),
            viewModel.cityWeather.value
        )
        coVerify { getCityWeatherUseCase.invoke(cityName) }
    }

    @Test
    fun `getCityWeather should update state with error on failure`() = runTest {
        val cityName = "Medellín"
        val exception = MessageException("Error fetching weather")
        val result = Either.Left(exception)
        coEvery { getCityWeatherUseCase.invoke(cityName) } returns result
        viewModel.getCityWeather(cityName)
        assertEquals(
            CityState(isLoading = false, error = exception.message),
            viewModel.cityWeather.value
        )
        coVerify { getCityWeatherUseCase.invoke(cityName) }
    }
}