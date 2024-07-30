package com.sali.anikfood.data.repoimpl

import com.sali.anikfood.data.entity.Favorite
import com.sali.anikfood.domain.repo.FavoriteRepo
import javax.inject.Inject

class FavoriteRepoImpl @Inject constructor(): FavoriteRepo {
    override suspend fun getAllFavorites(): List<Favorite> {
        TODO("Not yet implemented")
    }

    override suspend fun addFavorite(favorite: Favorite) {
        TODO("Not yet implemented")
    }

    override suspend fun updateFavorite(favorite: Favorite) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteFavorite(favorite: Favorite) {
        TODO("Not yet implemented")
    }
}