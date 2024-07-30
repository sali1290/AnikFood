package com.sali.anikfood.data.repoimpl

import com.sali.anikfood.data.entity.Favorite
import com.sali.anikfood.data.service.dao.FavoriteDao
import com.sali.anikfood.domain.repo.FavoriteRepo
import javax.inject.Inject

class FavoriteRepoImpl @Inject constructor(private val favoriteDao: FavoriteDao) : FavoriteRepo {

    override suspend fun getUserFavorites(userId: Int): List<Favorite> {
        return favoriteDao.getUserFavorites(userId)
    }

    override suspend fun addFavorite(favorite: Favorite) {
        favoriteDao.addFavorite(favorite)
    }

    override suspend fun deleteFavorite(favorite: Favorite) {
        favoriteDao.deleteFavorite(favorite)
    }

}