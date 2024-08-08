package co.cmedina.weather.ui.searchcity.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.cmedina.weather.di.IODispatcher
import co.cmedina.weather.domain.model.City
import co.cmedina.weather.domain.usecase.GetCityByNameUseCase
import co.cmedina.weather.ui.searchcity.state.SearchCityState
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

    private val _cityList: MutableStateFlow<SearchCityState> = MutableStateFlow(SearchCityState())
    val cityListState = _cityList.asStateFlow()

    fun searchCityByName(cityName: String) {
        viewModelScope.launch(dispatcher) {
            _cityList.update { it.copy(isLoading = true) }
            getCityByNameUseCase.invoke(cityName).fold(
                ifLeft = { messageException: Throwable ->
                    _cityList.update {
                        it.copy(
                            isLoading = false,
                            error = messageException.message
                        )
                    }
                },
                ifRight = { cityListInfo: List<City> ->
                    _cityList.update { it.copy(cityList = cityListInfo, isLoading = false) }
                }
            )
        }
    }
}