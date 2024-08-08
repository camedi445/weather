package co.cmedina.weather.mapper

import co.cmedina.weather.data.mapper.toDomain
import co.cmedina.weather.data.model.CityWeatherResponse
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class CityWeatherApiMapperTest {

    private lateinit var gson: Gson

    @Before
    fun setUp() {
        gson = GsonBuilder().create()
    }

    @Test
    fun `toDomain should map CityWeatherResponse to CityWeather correctly`() {
        val json = """
        {
            "location": {
                "name": "London",
                "region": "City of London, Greater London",
                "country": "United Kingdom",
                "lat": 51.52,
                "lon": -0.11,
                "tz_id": "Europe/London",
                "localtime_epoch": 1628412885,
                "localtime": "2021-08-08 14:21"
            },
            "current": {
                "last_updated_epoch": 1628412880,
                "last_updated": "2021-08-08 14:21",
                "temp_c": 20.0,
                "temp_f": 68.0,
                "is_day": 1,
                "condition": {
                    "text": "Partly cloudy",
                    "icon": "//cdn.weatherapi.com/weather/64x64/day/116.png",
                    "code": 1003
                },
                "wind_mph": 13.6,
                "wind_kph": 22.0,
                "wind_degree": 270,
                "wind_dir": "W",
                "pressure_mb": 1012.0,
                "pressure_in": 29.88,
                "precip_mm": 0.0,
                "precip_in": 0.0,
                "humidity": 65,
                "cloud": 50,
                "feelslike_c": 20.0,
                "feelslike_f": 68.0,
                "windchill_c": 20.0,
                "windchill_f": 68.0,
                "heatindex_c": 20.0,
                "heatindex_f": 68.0,
                "dewpoint_c": 13.0,
                "dewpoint_f": 55.4,
                "vis_km": 10.0,
                "vis_miles": 6.0,
                "uv": 5.0,
                "gust_mph": 15.0,
                "gust_kph": 24.1
            },
            "forecast": {
                "forecastday": []
            }
        }
        """.trimIndent()

        val response = gson.fromJson(json, CityWeatherResponse::class.java)
        val cityWeather = response!!.toDomain()

        assertEquals("20", cityWeather.temperature)
        assertEquals("Partly cloudy", cityWeather.condition)
        assertEquals("2021-08-08", cityWeather.localTime)
        assertEquals("14:21", cityWeather.hour)
        assertEquals("https:////cdn.weatherapi.com/weather/64x64/day/116.png", cityWeather.conditionIconUrl)
        assertEquals("65", cityWeather.humidity)
        assertEquals("270", cityWeather.wind)
        assertEquals("29.88", cityWeather.pressure)
        assertEquals("50", cityWeather.visibility)
    }
}