package co.cmedina.weather.state

import co.cmedina.weather.domain.model.CityWeather
import co.cmedina.weather.ui.city.state.CityState
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import org.junit.Test

class CityStateTest {

    @Test
    fun `CityState should initialize with default values`() {
        val state = CityState()

        assertEquals(false, state.isLoading)
        assertEquals(null, state.cityWeather)
        assertEquals(null, state.error)
    }

    @Test
    fun `CityState should update isLoading correctly`() {
        val state = CityState(isLoading = true)

        assertEquals(true, state.isLoading)
        assertEquals(null, state.cityWeather)
        assertEquals(null, state.error)
    }

    @Test
    fun `CityState should update cityWeather correctly`() {
        val cityWeather = mockk<CityWeather>()
        val state = CityState(cityWeather = cityWeather)

        assertEquals(false, state.isLoading)
        assertEquals(cityWeather, state.cityWeather)
        assertEquals(null, state.error)
    }

    @Test
    fun `CityState should update error correctly`() {
        val errorMessage = "Error fetching data"
        val state = CityState(error = errorMessage)

        assertEquals(false, state.isLoading)
        assertEquals(null, state.cityWeather)
        assertEquals(errorMessage, state.error)
    }
}