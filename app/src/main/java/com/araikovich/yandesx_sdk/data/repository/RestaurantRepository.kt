package com.araikovich.yandesx_sdk.data.repository

import com.araikovich.yandesx_sdk.data.base.ResultWrapper
import com.araikovich.yandesx_sdk.data.datasource.local.RestaurantLocalDataSource
import com.araikovich.yandesx_sdk.data.datasource.local.model.RestaurantItemEntity
import com.araikovich.yandesx_sdk.data.datasource.remote.RestaurantRemoteDataSource
import com.araikovich.yandesx_sdk.data.datasource.remote.model.RestaurantItemResponse
import com.araikovich.yandesx_sdk.data.mapper.Mapper
import com.araikovich.yandesx_sdk.ui.restaurant_list.models.RestaurantViewItem
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RestaurantRepository @Inject constructor(
    private val localDataSource: RestaurantLocalDataSource,
    private val remoteDataSource: RestaurantRemoteDataSource,
    private val restaurantEntityToModelMapper: Mapper<RestaurantItemEntity, RestaurantViewItem>,
    private val restaurantResponseToEntityMapper: Mapper<RestaurantItemResponse, RestaurantItemEntity>,
    private val dispatcher: CoroutineDispatcher
) {

    suspend fun fetchRestaurants(): Flow<ResultWrapper<List<RestaurantViewItem>>> {
        return flow {
            val localData = localDataSource.getAllRestaurants()
            if (localData.isSuccess() && localData.asSuccess().value.isNotEmpty()) {
                emit(ResultWrapper.Success(restaurantEntityToModelMapper.list(localData.asSuccess().value)))
            }
            when (val response = remoteDataSource.getRestaurants()) {
                is ResultWrapper.Success -> {
                    val entities =
                        restaurantResponseToEntityMapper.list(response.value.results.orEmpty())
                    localDataSource.saveRestaurants(entities)
                    emit(ResultWrapper.Success(restaurantEntityToModelMapper.list(entities)))
                }
                is ResultWrapper.Error -> {
                    emit(ResultWrapper.Error.UnknownError("fail fetch data"))
                }
            }
        }.flowOn(dispatcher)
    }
}