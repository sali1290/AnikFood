package com.sali.anikfood.domain.usecase.food

import com.sali.anikfood.domain.repo.FoodRepo
import javax.inject.Inject

class GetUserFavoriteFoods @Inject constructor(private val foodRepo: FoodRepo) {
    suspend fun invoke(foodIds: List<Int>) = foodRepo.getUserFavoriteFoods(foodIds)
}