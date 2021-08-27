package com.araikovich.yandesx_sdk.data.api

import com.araikovich.yandesx_sdk.data.datasource.remote.model.GetRestaurantsResponse
import com.araikovich.yandesx_sdk.data.datasource.remote.model.RestaurantItemResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RestaurantsApi {

    @GET("recipes/complexSearch")
    suspend fun getAllRestaurants(
        @Query("addRecipeInformation")
        addRecipeInformation: Boolean = true
    ): Response<GetRestaurantsResponse>
}