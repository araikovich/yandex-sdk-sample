package com.araikovich.yandesx_sdk.data.db.converters

import com.araikovich.yandesx_sdk.data.datasource.local.model.RestaurantItemEntity
import com.araikovich.yandesx_sdk.data.datasource.remote.model.RestaurantItemResponse
import com.araikovich.yandesx_sdk.data.mapper.Mapper
import com.araikovich.yandesx_sdk.ui.base.orZero

class RestaurantResponseToEntityMapper: Mapper<RestaurantItemResponse, RestaurantItemEntity>{
    override fun map(source: RestaurantItemResponse): RestaurantItemEntity {
        return RestaurantItemEntity(
            source.id.orZero(),
            source.name.orEmpty(),
            source.imageSrc.orEmpty(),
            source.categories.orEmpty(),
            source.timeForDelivery.orZero(),
            source.deliveryPrice.orZero()
        )
    }
}