package co.cmedina.weather.ui.city.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.cmedina.weather.ui.theme.WeatherTheme

@Composable
fun CityTitle(
    cityName: String,
    hour: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(24.dp)
    ) {
        Text(text = cityName, style = MaterialTheme.typography.titleMedium)
        Text(text = hour)
    }
}

@Composable
@Preview(showBackground = true)
fun CityTitlePreview() {
    WeatherTheme {
        CityTitle("Medellín", " 17:50")
    }
}