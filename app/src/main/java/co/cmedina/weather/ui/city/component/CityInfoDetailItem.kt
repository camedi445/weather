package co.cmedina.weather.ui.city.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.cmedina.weather.R
import co.cmedina.weather.ui.theme.WeatherTheme

@Composable
fun CityInfoDetailItem(
    @DrawableRes imageIcon: Int,
    title: String,
    property: String
) {
    Column(
        modifier = Modifier.padding(horizontal = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(50.dp),
            painter = painterResource(id = imageIcon),
            colorFilter = ColorFilter.tint(Color(0xFF6563ff)),
            contentDescription = "" // todo add resource to the content desc
        )
        Text(
            text = title,
            style = MaterialTheme.typography.labelMedium.copy(color = Color.Black)
        )
        Text(
            text = property,
            style = MaterialTheme.typography.labelMedium.copy(color = Color.Black)
        )
    }
}