package co.cmedina.weather.domain.model

data class CityWeather(
    val temperature: String,
    val condition: String,
    val localTime: String,
    val hour: String,
    val conditionIconUrl: String,
    val humidity: String,
    val wind: String,
    val pressure: String,
    val visibility: String,
    val days: List<Day>
)


data class Day(
    val temperature: String,
    val condition: String,
    val iconUrl: String
)
