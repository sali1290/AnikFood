package com.sali.anikfood.domain.usecase.food

import com.sali.anikfood.data.entity.Food
import com.sali.anikfood.domain.repo.FoodRepo
import javax.inject.Inject

class DeleteFood @Inject constructor(private val foodRepo: FoodRepo) {
    suspend fun invoke(food: Food) = foodRepo.deleteFood(food)
}