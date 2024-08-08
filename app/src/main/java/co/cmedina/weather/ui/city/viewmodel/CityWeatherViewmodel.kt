package co.cmedina.weather.ui.city.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.cmedina.weather.di.IODispatcher
import co.cmedina.weather.domain.model.CityWeather
import co.cmedina.weather.domain.usecase.GetCityWeatherUseCase
import co.cmedina.weather.ui.city.state.CityState
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

    private val _cityWeather: MutableStateFlow<CityState> = MutableStateFlow(CityState())
    val cityWeather = _cityWeather.asStateFlow()

    fun getCityWeather(cityName: String) {
        _cityWeather.update { it.copy(isLoading = true) }
        viewModelScope.launch(dispatcher) {
            getCityWeatherUseCase.invoke(cityName).fold(
                ifLeft = { messageException: Throwable ->
                    _cityWeather.update {
                        it.copy(
                            isLoading = false,
                            error = messageException.message
                        )
                    }
                },
                ifRight = { cityInfo: CityWeather ->
                    _cityWeather.update { it.copy(isLoading = false, cityWeather = cityInfo) }
                }
            )

        }
    }
}