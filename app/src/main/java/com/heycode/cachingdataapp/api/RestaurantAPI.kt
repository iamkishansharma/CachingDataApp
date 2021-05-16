package com.heycode.cachingdataapp.api

import com.heycode.cachingdataapp.data.Restaurant
import retrofit2.http.GET

interface RestaurantAPI {
    companion object {
        const val BASE_URL = "https://random-data-api.com/api/"
    }

    @GET("restaurant/random_restaurant?size=20")
    suspend fun getRestaurants(): List<Restaurant>
}