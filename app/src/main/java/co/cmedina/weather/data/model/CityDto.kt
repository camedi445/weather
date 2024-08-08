package co.cmedina.weather.data.model

import co.cmedina.weather.domain.model.City

data class CityDto(
    val id: Int,
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double,
    val url: String
) {

    fun toDomainCity() = City(
        id = id,
        name = name,
        country = country
    )
}
