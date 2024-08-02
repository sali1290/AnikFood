package com.sali.anikfood.domain.repo

import com.sali.anikfood.domain.model.FavoriteModel

interface FavoriteRepo {

    suspend fun getUserFavorites(userId: Int): List<FavoriteModel>

    suspend fun addFavorite(favoriteModel: FavoriteModel)

    suspend fun deleteFavorite(favoriteModel: FavoriteModel)

}