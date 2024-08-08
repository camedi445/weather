package co.cmedina.weather.state

import co.cmedina.weather.domain.model.City
import co.cmedina.weather.ui.searchcity.state.SearchCityState
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import org.junit.Test

class SearchCityStateTest {

    @Test
    fun `test SearchCityState default values`() {
        val state = SearchCityState()
        assertEquals(false, state.isLoading)
        assertEquals(emptyList<City>(), state.cityList)
        assertEquals(null, state.error)
    }

    @Test
    fun `test SearchCityState with values`() {
        val cityMock = mockk<City>()
        every { cityMock.name } returns "Medellin"
        every { cityMock.country } returns "Colombia"

        val state = SearchCityState(
            isLoading = true,
            cityList = listOf(cityMock),
            error = "Error message"
        )

        assertEquals(true, state.isLoading)
        assertEquals(1, state.cityList.size)
        assertEquals("Medellin", state.cityList[0].name)
        assertEquals("Colombia", state.cityList[0].country)
        assertEquals("Error message", state.error)
    }
}