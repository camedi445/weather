package co.cmedina.weather.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import co.cmedina.weather.ui.city.CityScreen
import co.cmedina.weather.ui.searchcity.SearchCityScreen

@Composable
fun WeatherNavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = SEARCH_CITY_ROUTE
    ) {
        composable(SEARCH_CITY_ROUTE) {
            SearchCityScreen { cityName ->
                navHostController.navigate("$CITY_ROUTE/$cityName")
            }
        }
        composable(
            route = "$CITY_ROUTE/{$CITY_NAME_PARAM}",
            arguments = listOf(navArgument(CITY_NAME_PARAM) { type = NavType.StringType })
        ) {
            it.arguments?.getString(CITY_NAME_PARAM)?.let { cityName ->
                CityScreen(cityName)
            }
        }
    }
}


private const val SEARCH_CITY_ROUTE = "search_city_route"
private const val CITY_ROUTE = "city_route"
private const val CITY_NAME_PARAM = "city_name"
