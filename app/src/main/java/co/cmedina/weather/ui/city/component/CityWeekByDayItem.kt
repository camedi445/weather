package co.cmedina.weather.ui.city.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.cmedina.weather.ui.theme.WeatherTheme
import coil.compose.AsyncImage

@Composable
fun CityWeekByDayItem(
    temperature: String,
    condition: String,
    iconUrl: String
) {
    Card(
        modifier = Modifier
            .size(width = 96.dp, height = 156.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFA89EF0)),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        shape = RoundedCornerShape(24.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "${temperature}°",
                    style = MaterialTheme.typography.labelMedium,
                    textAlign = TextAlign.Center
                )
                AsyncImage(
                    model = iconUrl ,
                    modifier = Modifier
                        .size(50.dp),
                    contentScale = ContentScale.Crop,
                    contentDescription = "" // todo add resource to the content desc
                )

                Text(
                    text = condition,
                    style = MaterialTheme.typography.labelSmall,
                    textAlign = TextAlign.Center
                )
            }
        }
    }

}
