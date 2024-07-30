package com.sali.anikfood.domain.repo

import com.sali.anikfood.data.entity.Favorite

interface FavoriteRepo {

    suspend fun getAllFavorites(): List<Favorite>

    suspend fun addFavorite(favorite: Favorite)

    suspend fun updateFavorite(favorite: Favorite)

    suspend fun deleteFavorite(favorite: Favorite)

}