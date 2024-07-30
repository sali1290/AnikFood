package com.sali.anikfood.domain.usecase.favorite

import com.sali.anikfood.data.entity.Favorite
import com.sali.anikfood.domain.repo.FavoriteRepo
import javax.inject.Inject

class AddFavorite @Inject constructor(private val favoriteRepo: FavoriteRepo) {
    suspend fun invoke(favorite: Favorite) = favoriteRepo.addFavorite(favorite)
}