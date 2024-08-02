package com.sali.anikfood.domain.usecase.favorite

import com.sali.anikfood.domain.model.FavoriteModel
import com.sali.anikfood.domain.repo.FavoriteRepo
import javax.inject.Inject

class AddFavorite @Inject constructor(private val favoriteRepo: FavoriteRepo) {
    suspend fun invoke(favoriteModel: FavoriteModel) = favoriteRepo.addFavorite(favoriteModel)
}