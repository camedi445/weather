package co.cmedina.weather.ui.city

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.cmedina.weather.ui.city.component.CityDate
import co.cmedina.weather.ui.city.component.CityInfoDetailCard
import co.cmedina.weather.ui.city.component.CityTemperatureCard
import co.cmedina.weather.ui.city.component.CityTitle
import co.cmedina.weather.ui.city.component.HorizontalDayByHourList

@Composable
fun CityScreen() {
    Scaffold { paddingValues ->
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
                CityTemperatureCard()
                CityDate()
            }
            CityInfoDetailCard()
            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDayByHourList()
        }
    }
}