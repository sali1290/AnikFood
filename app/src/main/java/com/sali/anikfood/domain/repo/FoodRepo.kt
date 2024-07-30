package com.sali.anikfood.domain.repo

import com.sali.anikfood.data.entity.Food

interface FoodRepo {

    suspend fun getAllFoods(): List<Food>

    suspend fun getUserFavoriteFoods(foodIds: List<Int>): List<Food>

    suspend fun addFood(food: Food)

    suspend fun deleteFood(food: Food)

}