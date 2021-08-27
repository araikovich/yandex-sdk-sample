package com.araikovich.yandesx_sdk.domain

import com.araikovich.yandesx_sdk.data.base.ResultWrapper
import com.araikovich.yandesx_sdk.data.repository.RestaurantRepository
import com.araikovich.yandesx_sdk.ui.restaurant_list.models.RestaurantViewItem
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetRestaurantListUseCase @Inject constructor(
    private val repository: RestaurantRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend fun invoke(): Flow<ResultWrapper<List<RestaurantViewItem>>> {
        return repository.fetchRestaurants().flowOn(coroutineDispatcher)
    }
}