package com.sali.anikfood.domain.usecase.food

import com.sali.anikfood.domain.model.FoodModel
import com.sali.anikfood.domain.repo.FoodRepo
import javax.inject.Inject

class AddFood @Inject constructor(private val foodRepo: FoodRepo) {
    suspend fun invoke(foodModel: FoodModel) = foodRepo.addFood(foodModel)
}