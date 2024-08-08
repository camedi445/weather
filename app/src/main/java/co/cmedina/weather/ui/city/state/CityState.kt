package co.cmedina.weather.ui.city.state

import co.cmedina.weather.domain.model.CityWeather

data class CityState(
    val isLoading: Boolean = false,
    val cityWeather: CityWeather? = null,
    val error: String? = null
)
