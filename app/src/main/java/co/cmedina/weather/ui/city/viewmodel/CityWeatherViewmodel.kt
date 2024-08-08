package co.cmedina.weather.ui.city.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.cmedina.weather.di.IODispatcher
import co.cmedina.weather.domain.model.CityWeather
import co.cmedina.weather.domain.usecase.GetCityWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CityWeatherViewmodel @Inject constructor(
    private val getCityWeatherUseCase: GetCityWeatherUseCase,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _cityWeather: MutableStateFlow<CityWeather?> = MutableStateFlow(null)
    val cityWeather = _cityWeather.asStateFlow()

    fun getCityWeather(cityName: String) {
        viewModelScope.launch(dispatcher) {
            getCityWeatherUseCase.invoke(cityName).also { data ->
                _cityWeather.update { data }
            }
        }
    }

}