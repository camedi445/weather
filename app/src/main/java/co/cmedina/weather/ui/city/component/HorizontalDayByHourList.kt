package co.cmedina.weather.ui.city.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.cmedina.weather.ui.theme.WeatherTheme

@Composable
fun HorizontalDayByHourList() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Hoy")
        Text(text = "Siguientes 7 días")
    }
    Row(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        CityInfoDetailItem()
        CityInfoDetailItem()
        CityInfoDetailItem()
        CityInfoDetailItem()
    }
}


@Composable
@Preview(showBackground = true)
fun HorizontalDayByHourListPreview() {
    WeatherTheme {
        HorizontalDayByHourList()
    }
}