package com.sali.anikfood.data.repoimpl

import com.sali.anikfood.data.entity.Food
import com.sali.anikfood.data.service.dao.FoodDao
import com.sali.anikfood.domain.repo.FoodRepo
import javax.inject.Inject

class FoodRepoImpl @Inject constructor(private val foodDao: FoodDao) : FoodRepo {
    override suspend fun getAllFoods(): List<Food> {
        return foodDao.getAllFoods()
    }

    override suspend fun getUserFavoriteFoods(foodIds: List<Int>): List<Food> {
        return foodDao.getFoodsByIds(foodIds)
    }

    override suspend fun addFood(food: Food) {
        foodDao.addFood(food)
    }

    override suspend fun deleteFood(food: Food) {
        foodDao.deleteFood(food)
    }
}