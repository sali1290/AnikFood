package com.sali.anikfood.data.repoimpl

import com.sali.anikfood.data.entity.Food
import com.sali.anikfood.domain.repo.FoodRepo
import javax.inject.Inject

class FoodRepoImpl @Inject constructor(): FoodRepo {
    override suspend fun getAllFoods(): List<Food> {
        TODO("Not yet implemented")
    }

    override suspend fun getUserFavoriteFoods(foodIds: List<Int>): List<Food> {
        TODO("Not yet implemented")
    }

    override suspend fun addFood(food: Food) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteFood(food: Food) {
        TODO("Not yet implemented")
    }
}