package com.araikovich.yandesx_sdk.ui.restaurant_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.araikovich.yandesx_sdk.domain.GetRestaurantListUseCase
import com.araikovich.yandesx_sdk.ui.base.ActionResource
import com.araikovich.yandesx_sdk.ui.base.error
import com.araikovich.yandesx_sdk.ui.base.loading
import com.araikovich.yandesx_sdk.ui.base.success
import com.araikovich.yandesx_sdk.ui.restaurant_list.models.RestaurantViewItem
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class RestaurantListViewModel @Inject constructor(
    private val useCase: GetRestaurantListUseCase
) : ViewModel() {

    private val _restaurantsLiveData = MutableLiveData<ActionResource<List<RestaurantViewItem>>>()
    val restaurantsLiveData: LiveData<ActionResource<List<RestaurantViewItem>>> = _restaurantsLiveData

    fun getRestaurants() {
        viewModelScope.launch {
            _restaurantsLiveData.loading(true)
            useCase.invoke().collect {
               it.doOnResult(
                   onSuccess = { result ->
                       _restaurantsLiveData.success(result)
                   },
                   onError = { error ->
                       _restaurantsLiveData.error(error.msg)
                   }
               )
            }
        }
    }
}