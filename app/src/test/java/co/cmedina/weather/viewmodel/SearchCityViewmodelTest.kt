package co.cmedina.weather.viewmodel

import arrow.core.Either
import co.cmedina.weather.domain.exception.MessageException
import co.cmedina.weather.domain.model.City
import co.cmedina.weather.domain.usecase.GetCityByNameUseCase
import co.cmedina.weather.rule.MainCoroutineRule
import co.cmedina.weather.ui.searchcity.state.SearchCityState
import co.cmedina.weather.ui.searchcity.viewmodel.SearchCityViewmodel
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class SearchCityViewmodelTest {

    private val dispatcher = UnconfinedTestDispatcher()

    @get:Rule
    val coroutineRule = MainCoroutineRule(dispatcher)

    private lateinit var viewModel: SearchCityViewmodel
    private val getCityByNameUseCase: GetCityByNameUseCase = mockk()

    @Before
    fun setUp() {
        viewModel = SearchCityViewmodel(
            getCityByNameUseCase = getCityByNameUseCase,
            dispatcher = dispatcher
        )
    }

    @Test
    fun `searchCityByName should update state with city list on success`() = runTest {
        val cityName = "Medellín"
        val city = mockk<City>()
        val cityListInfo = listOf(city)
        val result = Either.Right(cityListInfo)
        coEvery { getCityByNameUseCase.invoke(cityName) } returns result
        viewModel.searchCityByName(cityName)
        assertEquals(
            SearchCityState(cityList = cityListInfo, isLoading = false),
            viewModel.cityListState.value
        )
    }

    @Test
    fun `searchCityByName should update state with error on failure`() = runTest {
        val cityName = "Medellín"
        val exception = MessageException("Error fetching city list")
        val result = Either.Left(exception)
        coEvery { getCityByNameUseCase.invoke(cityName) } returns result
        viewModel.searchCityByName(cityName)
        assertEquals(
            SearchCityState(isLoading = false, error = exception.message),
            viewModel.cityListState.value
        )
    }
}