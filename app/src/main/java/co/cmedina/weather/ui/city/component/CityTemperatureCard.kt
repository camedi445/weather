package co.cmedina.weather.ui.city.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.cmedina.weather.ui.theme.WeatherTheme
import coil.compose.AsyncImage

@Composable
fun CityTemperatureCard(
    temperature: String,
    condition: String,
    imageUrl: String
) {
    Card(
        modifier = Modifier
            .size(width = 280.dp, height = 280.dp)
            .padding(top = 26.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        shape = RoundedCornerShape(52.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.radialGradient(
                        listOf(
                            Color(0xFF9892D0),
                            Color(0xFF4B3FAF)
                        )
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                AsyncImage(
                    model = imageUrl,
                    modifier = Modifier
                        .size(180.dp)
                        .offset(y = (-20).dp),
                    contentScale = ContentScale.Crop,
                    contentDescription = "" // todo add resource to the content desc
                )
                Column(
                    modifier = Modifier
                        .offset(y = (-35).dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "${temperature}°",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White
                    )
                    Text(
                        text = condition,
                        style = MaterialTheme.typography.labelMedium,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CityTemperatureCardPreview() {
    WeatherTheme {
        Box(modifier = Modifier.padding(24.dp)) {
            CityTemperatureCard(
                temperature = "23",
                condition = "mayormente nublado",
                imageUrl = "url"
            )
        }
    }
}