package com.sali.anikfood.domain.repo

import com.sali.anikfood.domain.model.FoodModel

interface FoodRepo {

    suspend fun getAllFoods(): List<FoodModel>

    suspend fun getUserFavoriteFoods(foodIds: List<Int>): List<FoodModel>

    suspend fun addFood(foodModel: FoodModel)

    suspend fun deleteFood(foodModel: FoodModel)

}