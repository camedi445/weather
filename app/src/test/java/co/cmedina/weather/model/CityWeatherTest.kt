package co.cmedina.weather.model

import co.cmedina.weather.domain.model.CityWeather
import co.cmedina.weather.domain.model.Day
import junit.framework.TestCase.assertEquals
import org.junit.Test

class CityWeatherTest {

    @Test
    fun `CityWeather should initialize correctly`() {
        val days = listOf(
            Day(temperature = "25°C", condition = "Sunny", iconUrl = "url1"),
            Day(temperature = "22°C", condition = "Cloudy", iconUrl = "url2")
        )
        val cityWeather = CityWeather(
            temperature = "24°C",
            condition = "Partly Cloudy",
            localTime = "2024-08-08 12:00",
            hour = "12:00",
            conditionIconUrl = "iconUrl",
            humidity = "60%",
            wind = "10 km/h",
            pressure = "1013 hPa",
            visibility = "10 km",
            days = days
        )

        assertEquals("24°C", cityWeather.temperature)
        assertEquals("Partly Cloudy", cityWeather.condition)
        assertEquals("2024-08-08 12:00", cityWeather.localTime)
        assertEquals("12:00", cityWeather.hour)
        assertEquals("iconUrl", cityWeather.conditionIconUrl)
        assertEquals("60%", cityWeather.humidity)
        assertEquals("10 km/h", cityWeather.wind)
        assertEquals("1013 hPa", cityWeather.pressure)
        assertEquals("10 km", cityWeather.visibility)
        assertEquals(days, cityWeather.days)
    }

    @Test
    fun `Day should initialize correctly`() {
        val day = Day(
            temperature = "25°C",
            condition = "Sunny",
            iconUrl = "url1"
        )

        assertEquals("25°C", day.temperature)
        assertEquals("Sunny", day.condition)
        assertEquals("url1", day.iconUrl)
    }

}