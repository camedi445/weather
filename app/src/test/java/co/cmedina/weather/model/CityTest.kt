package co.cmedina.weather.model

import co.cmedina.weather.domain.model.City
import junit.framework.TestCase.assertEquals
import org.junit.Test

class CityTest {

    @Test
    fun `City should initialize correctly`() {
        val city = City(id = 1, name = "Medellín", country = "Colombia")

        assertEquals(1, city.id)
        assertEquals("Medellín", city.name)
        assertEquals("Colombia", city.country)
    }

    @Test
    fun `City properties should be accessible`() {
        val city = City(id = 2, name = "Bogotá", country = "Colombia")

        assertEquals(2, city.id)
        assertEquals("Bogotá", city.name)
        assertEquals("Colombia", city.country)
    }

    @Test
    fun `City should handle different data correctly`() {
        val city = City(id = 3, name = "Cali", country = "Colombia")

        assertEquals(3, city.id)
        assertEquals("Cali", city.name)
        assertEquals("Colombia", city.country)
    }
}