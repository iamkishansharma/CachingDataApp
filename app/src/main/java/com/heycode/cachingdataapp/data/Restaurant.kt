package com.heycode.cachingdataapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurants")
data class Restaurant(
    val name: String,
    val type: String,
    val logo: String,
    val address: String,
    val description: String,
    @PrimaryKey val phone_number: String,
)