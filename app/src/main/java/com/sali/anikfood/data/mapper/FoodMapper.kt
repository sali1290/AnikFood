package com.sali.anikfood.data.mapper

import com.sali.anikfood.data.entity.Food
import com.sali.anikfood.domain.model.FoodModel
import javax.inject.Inject

class FoodMapper @Inject constructor(){

    fun convertFoodToFoodModel(food: Food): FoodModel {
        return FoodModel(foodId = food.foodId, foodName = food.foodName)
    }

    fun convertFoodModelToFood(foodModel: FoodModel): Food {
        return Food(foodId = foodModel.foodId, foodName = foodModel.foodName)
    }

}