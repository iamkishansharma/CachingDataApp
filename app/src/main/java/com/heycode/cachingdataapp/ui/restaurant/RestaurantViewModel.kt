package com.heycode.cachingdataapp.ui.restaurant

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.heycode.cachingdataapp.api.RestaurantAPI
import com.heycode.cachingdataapp.data.Restaurant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(api: RestaurantAPI) : ViewModel() {
    private val restaurantLiveData = MutableLiveData<List<Restaurant>>()

    //This will allow activity only to read the not change it
    val restaurant: LiveData<List<Restaurant>> = restaurantLiveData

    init {
        viewModelScope.launch {
            val restaurants = api.getRestaurants()

            //this is only to show th progressbar
            //fakes like it is loading the data
            delay(2000L)

            restaurantLiveData.value = restaurants
        }
    }
}