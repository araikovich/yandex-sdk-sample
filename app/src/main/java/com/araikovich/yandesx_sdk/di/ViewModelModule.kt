package com.araikovich.yandesx_sdk.di

import androidx.lifecycle.ViewModel
import com.araikovich.yandesx_sdk.ui.restaurant_list.RestaurantListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @[IntoMap ViewModelKey(RestaurantListViewModel::class)]
    fun provideMainViewModel(restaurantListViewModel: RestaurantListViewModel): ViewModel
}