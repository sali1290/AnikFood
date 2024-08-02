package com.sali.anikfood.data.repoimpl

import com.sali.anikfood.data.mapper.FoodMapper
import com.sali.anikfood.data.service.dao.FoodDao
import com.sali.anikfood.domain.model.FoodModel
import com.sali.anikfood.domain.repo.FoodRepo
import javax.inject.Inject

class FoodRepoImpl @Inject constructor(
    private val foodDao: FoodDao,
    private val mapper: FoodMapper
) : FoodRepo {
    override suspend fun getAllFoods(): List<FoodModel> {
        return foodDao.getAllFoods().map { mapper.convertFoodToFoodModel(it) }
    }

    override suspend fun getUserFavoriteFoods(foodIds: List<Int>): List<FoodModel> {
        return foodDao.getFoodsByIds(foodIds).map { mapper.convertFoodToFoodModel(it) }
    }

    override suspend fun addFood(foodModel: FoodModel) {
        val food = mapper.convertFoodModelToFood(foodModel)
        foodDao.addFood(food)
    }

    override suspend fun deleteFood(foodModel: FoodModel) {
        val food = mapper.convertFoodModelToFood(foodModel)
        foodDao.deleteFood(food)
    }
}