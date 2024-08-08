package co.cmedina.weather.ui.searchcity.state

import co.cmedina.weather.domain.model.City

data class SearchCityState(
    val isLoading: Boolean = false,
    val cityList: List<City> = emptyList(),
    val error: String? = null
)
