package com.sali.anikfood.domain.usecase.favorite

import com.sali.anikfood.domain.repo.FavoriteRepo
import javax.inject.Inject

class GetUserFavorites @Inject constructor(private val favoriteRepo: FavoriteRepo) {
    suspend fun invoke(userId: Int) = favoriteRepo.getUserFavorites(userId)
}