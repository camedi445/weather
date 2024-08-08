package co.cmedina.weather.data.api

import co.cmedina.weather.data.model.CityDto
import co.cmedina.weather.data.model.CityWeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("search.json")
    suspend fun fetchCityByName(
        @Query("q") cityName: String,
        @Query("key") key: String
    ): List<CityDto>

    @GET("forecast.json")
    suspend fun fetchCityWeather(
        @Query("key") key: String,
        @Query("q") cityName: String,
        @Query("days") days: String
    ): CityWeatherResponse
}
