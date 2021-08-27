package com.araikovich.yandesx_sdk.data.datasource.remote

import com.araikovich.yandesx_sdk.data.api.RestaurantsApi
import com.araikovich.yandesx_sdk.data.base.ResultWrapper
import com.araikovich.yandesx_sdk.data.base.safeApiCall
import com.araikovich.yandesx_sdk.data.datasource.remote.model.GetRestaurantsResponse
import com.araikovich.yandesx_sdk.data.datasource.remote.model.RestaurantItemResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RestaurantRemoteDataSource @Inject constructor(
    private val restaurantsApi: RestaurantsApi,
    private val dispatcher: CoroutineDispatcher
) {

    suspend fun getRestaurants(): ResultWrapper<GetRestaurantsResponse> {
        return withContext(dispatcher) {
            safeApiCall { restaurantsApi.getAllRestaurants() }
        }
    }
}