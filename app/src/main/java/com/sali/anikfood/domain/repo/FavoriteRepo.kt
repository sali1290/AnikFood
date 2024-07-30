package com.sali.anikfood.domain.repo

import com.sali.anikfood.data.entity.Favorite

interface FavoriteRepo {

    suspend fun getUserFavorites(userId: Int): List<Favorite>

    suspend fun addFavorite(favorite: Favorite)

    suspend fun deleteFavorite(favorite: Favorite)

}