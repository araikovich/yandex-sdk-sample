package com.araikovich.yandesx_sdk.ui.restaurant_list.models

sealed class RestaurantCategory {
    object None: RestaurantCategory()
    object Chinese : RestaurantCategory()
    object Japan : RestaurantCategory()
    object European : RestaurantCategory()
    object HomeFood : RestaurantCategory()
    object FastFood : RestaurantCategory()
    object Vegan : RestaurantCategory()

    companion object {
        fun mapCategoryId(categoryId: Int): RestaurantCategory {
            return when (categoryId) {
                1 -> Chinese
                2 -> Japan
                3 -> European
                4 -> HomeFood
                5 -> FastFood
                6 -> Vegan
                else -> None
            }
        }
    }
}