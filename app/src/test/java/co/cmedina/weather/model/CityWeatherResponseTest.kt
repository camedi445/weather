package co.cmedina.weather.model

import co.cmedina.weather.data.model.CityWeatherResponse
import co.cmedina.weather.data.model.ConditionDto
import co.cmedina.weather.data.model.CurrentDto
import co.cmedina.weather.data.model.ForecastDto
import co.cmedina.weather.data.model.LocationDto
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class CityWeatherResponseTest {

    private lateinit var gson: Gson

    @Before
    fun setUp() {
        gson = GsonBuilder().create()
    }

    @Test
    fun `test CityWeatherResponse deserialization`() {
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

        // Verifica que el objeto no sea nulo
        assertNotNull(response)

        // Verifica los datos de LocationDto
        assertEquals("London", response.location.name)
        assertEquals("City of London, Greater London", response.location.region)
        assertEquals("United Kingdom", response.location.country)
        assertEquals(51.52, response.location.lat, 0.0)
        assertEquals(-0.11, response.location.lon, 0.0)
        assertEquals("Europe/London", response.location.tzId)
        assertEquals(1628412885L, response.location.localtimeEpoch)
        assertEquals("2021-08-08 14:21", response.location.localtime)

        // Verifica los datos de CurrentDto
        assertEquals(1628412880L, response.current.lastUpdatedEpoch)
        assertEquals("2021-08-08 14:21", response.current.lastUpdated)
        assertEquals(20.0, response.current.tempC, 0.0)
        assertEquals(68.0, response.current.tempF, 0.0)
        assertEquals(1, response.current.isDay)
        assertEquals("Partly cloudy", response.current.condition.text)
        assertEquals(
            "//cdn.weatherapi.com/weather/64x64/day/116.png",
            response.current.condition.icon
        )
        assertEquals(1003, response.current.condition.code)
        assertEquals(13.6, response.current.windMph, 0.0)
        assertEquals(22.0, response.current.windKph, 0.0)
        assertEquals(270, response.current.windDegree)
        assertEquals("W", response.current.windDir)
        assertEquals(1012.0, response.current.pressureMb, 0.0)
        assertEquals(29.88, response.current.pressureIn, 0.0)
        assertEquals(0.0, response.current.precipMm, 0.0)
        assertEquals(0.0, response.current.precipIn, 0.0)
        assertEquals(65, response.current.humidity)
        assertEquals(50, response.current.cloud)
        assertEquals(20.0, response.current.feelslikeC, 0.0)
        assertEquals(68.0, response.current.feelslikeF, 0.0)
        assertEquals(20.0, response.current.windchillC, 0.0)
        assertEquals(68.0, response.current.windchillF, 0.0)
        assertEquals(20.0, response.current.heatindexC, 0.0)
        assertEquals(68.0, response.current.heatindexF, 0.0)
        assertEquals(13.0, response.current.dewpointC, 0.0)
        assertEquals(55.4, response.current.dewpointF, 0.0)
        assertEquals(10.0, response.current.visKm, 0.0)
        assertEquals(6.0, response.current.visMiles, 0.0)
        assertEquals(5.0, response.current.uv, 0.0)
        assertEquals(15.0, response.current.gustMph, 0.0)
        assertEquals(24.1, response.current.gustKph, 0.0)
    }
}