package co.cmedina.weather.di

import co.cmedina.weather.data.api.WeatherApi
import co.cmedina.weather.data.repository.CityRepositoryImpl
import co.cmedina.weather.domain.repository.CityRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object WeatherComponent {

    @Provides
    @ViewModelScoped
    fun provideCityRepository(weatherApi: WeatherApi):
            CityRepository = CityRepositoryImpl(weatherApi)
}