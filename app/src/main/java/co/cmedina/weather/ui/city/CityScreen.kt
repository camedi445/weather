package co.cmedina.weather.ui.city

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import co.cmedina.weather.ui.city.component.CityDate
import co.cmedina.weather.ui.city.component.CityInfoDetailCard
import co.cmedina.weather.ui.city.component.CityTemperatureCard
import co.cmedina.weather.ui.city.component.CityTitle
import co.cmedina.weather.ui.city.component.HorizontalWeekByDayList
import co.cmedina.weather.ui.city.viewmodel.CityWeatherViewmodel

@Composable
fun CityScreen(
    cityName: String,
    cityWeatherViewmodel: CityWeatherViewmodel = hiltViewModel()
) {

    val cityWeather by cityWeatherViewmodel.cityWeather.collectAsState()

    LaunchedEffect(Unit) {
        cityWeatherViewmodel.getCityWeather(cityName)
    }

    Scaffold { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.secondary
                        )
                    )
                ),
            color = Color.Transparent
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState()),
            ) {
                CityTitle()
                Spacer(modifier = Modifier.height(8.dp))
                Box(contentAlignment = Alignment.TopCenter) {
                    CityTemperatureCard(
                        temperature = cityWeather?.temperature ?: "",
                        condition = cityWeather?.condition ?: ""
                    ) // Todo refactor
                    CityDate()
                }
                CityInfoDetailCard()
                Spacer(modifier = Modifier.height(8.dp))
                HorizontalWeekByDayList()
            }
        }
    }
}