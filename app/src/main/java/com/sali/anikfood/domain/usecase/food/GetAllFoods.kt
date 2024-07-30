package com.sali.anikfood.domain.usecase.food

import com.sali.anikfood.domain.repo.FoodRepo
import javax.inject.Inject

class GetAllFoods @Inject constructor(private val foodRepo: FoodRepo) {
    suspend fun invoke() = foodRepo.getAllFoods()
}