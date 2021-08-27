package com.araikovich.yandesx_sdk.di

import com.araikovich.yandesx_sdk.data.datasource.local.model.RestaurantItemEntity
import com.araikovich.yandesx_sdk.data.datasource.remote.model.RestaurantItemResponse
import com.araikovich.yandesx_sdk.data.db.converters.RestaurantResponseToEntityMapper
import com.araikovich.yandesx_sdk.data.mapper.Mapper
import com.araikovich.yandesx_sdk.data.mapper.RestaurantEntityToModelMapper
import com.araikovich.yandesx_sdk.ui.restaurant_list.models.RestaurantViewItem
import dagger.Module
import dagger.Provides

@Module
class MapperModule {

    @Provides
    fun provideRestaurantResponseToEntityMapper(): Mapper<RestaurantItemResponse, RestaurantItemEntity> =
        RestaurantResponseToEntityMapper()

    @Provides
    fun prvideRestaurantEntityToResponseMapper(): Mapper<RestaurantItemEntity, RestaurantViewItem> =
        RestaurantEntityToModelMapper()
}