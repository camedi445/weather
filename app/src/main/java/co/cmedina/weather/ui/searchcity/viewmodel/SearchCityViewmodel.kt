package co.cmedina.weather.ui.searchcity.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.cmedina.weather.di.IODispatcher
import co.cmedina.weather.domain.model.City
import co.cmedina.weather.domain.usecase.GetCityByNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchCityViewmodel @Inject constructor(
    private val getCityByNameUseCase: GetCityByNameUseCase,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _cityList: MutableStateFlow<List<City>> = MutableStateFlow(emptyList())
    val cityList = _cityList.asStateFlow()

    fun searchCityByName(cityName: String) {
        viewModelScope.launch(dispatcher) {
            getCityByNameUseCase.invoke(cityName).also { data ->
                _cityList.update { data }
            }
        }
    }

}