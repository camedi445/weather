package co.cmedina.weather.ui.city.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.cmedina.weather.R
import co.cmedina.weather.ui.theme.WeatherTheme

@Composable
fun CityInfoDetailItem() {
    Column(
        modifier = Modifier.padding(horizontal = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(50.dp),
            painter = painterResource(id = R.drawable.cloud_mid_rain),
            contentDescription = "" // todo add resource to the content desc
        )
        Text(text = "75%")
        Text(text = "Humedad")
    }
}

@Composable
@Preview(showBackground = true)
fun CityInfoDetailItemPreview() {
    WeatherTheme {
        CityInfoDetailItem()
    }
}