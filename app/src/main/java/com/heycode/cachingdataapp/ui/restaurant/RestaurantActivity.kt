package com.heycode.cachingdataapp.ui.restaurant

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.heycode.cachingdataapp.databinding.ActivityRestaurantBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RestaurantActivity : AppCompatActivity() {
    private val viewModel: RestaurantViewModel by viewModels()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val restaurantAdapter = RestaurantAdapter()
        binding.apply {
            recyclerView.apply {
                recyclerView.adapter = restaurantAdapter
                layoutManager = LinearLayoutManager(this@RestaurantActivity)
            }
            viewModel.restaurant.observe(this@RestaurantActivity) { restaurants ->
                restaurantAdapter.submitList(restaurants)
            }
        }
    }
}