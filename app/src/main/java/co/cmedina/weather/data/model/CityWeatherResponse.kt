package co.cmedina.weather.data.model

import com.google.gson.annotations.SerializedName

data class CityWeatherResponse(
    val location: LocationDto,
    val current: CurrentDto,
    val forecast: ForecastDto
)

data class LocationDto(
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double,
    @SerializedName("tz_id") val tzId: String,
    @SerializedName("localtime_epoch") val localtimeEpoch: Long,
    val localtime: String
)

data class CurrentDto(
    @SerializedName("last_updated_epoch") val lastUpdatedEpoch: Long,
    @SerializedName("last_updated") val lastUpdated: String,
    @SerializedName("temp_c") val tempC: Double,
    @SerializedName("temp_f") val tempF: Double,
    @SerializedName("is_day") val isDay: Int,
    val condition: ConditionDto,
    @SerializedName("wind_mph") val windMph: Double,
    @SerializedName("wind_kph") val windKph: Double,
    @SerializedName("wind_degree") val windDegree: Int,
    @SerializedName("wind_dir") val windDir: String,
    @SerializedName("pressure_mb") val pressureMb: Double,
    @SerializedName("pressure_in") val pressureIn: Double,
    @SerializedName("precip_mm") val precipMm: Double,
    @SerializedName("precip_in") val precipIn: Double,
    @SerializedName("humidity") val humidity: Int,
    @SerializedName("cloud") val cloud: Int,
    @SerializedName("feelslike_c") val feelslikeC: Double,
    @SerializedName("feelslike_f") val feelslikeF: Double,
    @SerializedName("windchill_c") val windchillC: Double,
    @SerializedName("windchill_f") val windchillF: Double,
    @SerializedName("heatindex_c") val heatindexC: Double,
    @SerializedName("heatindex_f") val heatindexF: Double,
    @SerializedName("dewpoint_c") val dewpointC: Double,
    @SerializedName("dewpoint_f") val dewpointF: Double,
    @SerializedName("vis_km") val visKm: Double,
    @SerializedName("vis_miles") val visMiles: Double,
    val uv: Double,
    @SerializedName("gust_mph") val gustMph: Double,
    @SerializedName("gust_kph") val gustKph: Double
)

data class ConditionDto(
    val text: String,
    val icon: String,
    val code: Int
)

data class ForecastDto(
    val forecastDay: List<ForecastDayDto>
)

data class ForecastDayDto(
    val date: String,
    @SerializedName("date_epoch") val dateEpoch: Long,
    val day: DayDto,
    val astro: AstroDto,
    val hour: List<HourDto>
)

data class DayDto(
    @SerializedName("maxtemp_c") val maxTempC: Double,
    @SerializedName("maxtemp_f") val maxTempF: Double,
    @SerializedName("mintemp_c") val minTempC: Double,
    @SerializedName("mintemp_f") val minTempF: Double,
    @SerializedName("avgtemp_c") val avgTempC: Double,
    @SerializedName("avgtemp_f") val avgTempF: Double,
    @SerializedName("maxwind_mph") val maxWindMph: Double,
    @SerializedName("maxwind_kph") val maxWindKph: Double,
    @SerializedName("totalprecip_mm") val totalPrecipMm: Double,
    @SerializedName("totalprecip_in") val totalPrecipIn: Double,
    @SerializedName("totalsnow_cm") val totalSnowCm: Double,
    @SerializedName("avgvis_km") val avgVisKm: Double,
    @SerializedName("avgvis_miles") val avgVisMiles: Double,
    @SerializedName("avghumidity") val avgHumidity: Int,
    @SerializedName("daily_will_it_rain") val dailyWillItRain: Int,
    @SerializedName("daily_chance_of_rain") val dailyChanceOfRain: Int,
    @SerializedName("daily_will_it_snow") val dailyWillItSnow: Int,
    @SerializedName("daily_chance_of_snow") val dailyChanceOfSnow: Int,
    val condition: ConditionDto,
    val uv: Double
)

data class AstroDto(
    val sunrise: String,
    val sunset: String,
    val moonrise: String,
    val moonset: String,
    @SerializedName("moon_phase") val moonPhase: String,
    @SerializedName("moon_illumination") val moonIllumination: Int,
    @SerializedName("is_moon_up") val isMoonUp: Int,
    @SerializedName("is_sun_up") val isSunUp: Int
)

data class HourDto(
    @SerializedName("time_epoch") val timeEpoch: Long,
    @SerializedName("time") val time: String,
    @SerializedName("temp_c") val tempC: Double,
    @SerializedName("temp_f") val tempF: Double,
    @SerializedName("is_day") val isDay: Int,
    val condition: ConditionDto,
    @SerializedName("wind_mph") val windMph: Double,
    @SerializedName("wind_kph") val windKph: Double,
    @SerializedName("wind_degree") val windDegree: Int,
    @SerializedName("wind_dir") val windDir: String,
    @SerializedName("pressure_mb") val pressureMb: Double,
    @SerializedName("pressure_in") val pressureIn: Double,
    @SerializedName("precip_mm") val precipMm: Double,
    @SerializedName("precip_in") val precipIn: Double,
    @SerializedName("snow_cm") val snowCm: Double,
    val humidity: Int,
    val cloud: Int,
    @SerializedName("feelslike_c") val feelslikeC: Double,
    @SerializedName("feelslike_f") val feelslikeF: Double,
    @SerializedName("windchill_c") val windchillC: Double,
    @SerializedName("windchill_f") val windchillF: Double
)