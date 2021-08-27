package com.araikovich.yandesx_sdk.data.mapper

import com.araikovich.yandesx_sdk.data.datasource.local.model.RestaurantItemEntity
import com.araikovich.yandesx_sdk.ui.restaurant_list.models.RestaurantViewItem

class RestaurantEntityToModelMapper: Mapper<RestaurantItemEntity, RestaurantViewItem> {

    override fun map(source: RestaurantItemEntity): RestaurantViewItem {
        return RestaurantViewItem(
            source.id,
            source.name,
            source.imageSrc,
            source.categories,
            source.timeForDelivery,
            source.deliveryPrice
        )
    }
}