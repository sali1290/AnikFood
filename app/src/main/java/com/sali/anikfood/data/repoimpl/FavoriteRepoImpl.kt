package com.sali.anikfood.data.repoimpl

import android.util.Log
import com.sali.anikfood.data.mapper.FavoriteMapper
import com.sali.anikfood.data.service.dao.FavoriteDao
import com.sali.anikfood.domain.model.FavoriteModel
import com.sali.anikfood.domain.repo.FavoriteRepo
import javax.inject.Inject

class FavoriteRepoImpl @Inject constructor(
    private val favoriteDao: FavoriteDao,
    private val mapper: FavoriteMapper
) : FavoriteRepo {

    override suspend fun getUserFavorites(userId: Int): List<FavoriteModel> {
        return favoriteDao.getUserFavorites(userId).map {
            Log.d("AnikFood", it.toString())
            mapper.convertFavoriteToFavoriteModel(it)
        }
    }

    override suspend fun addFavorite(favoriteModel: FavoriteModel) {
        val favorite = mapper.convertFavoriteModelToFavorite(favoriteModel)
        Log.d("AnikFood", "added: $favorite")
        favoriteDao.addFavorite(favorite)
    }

    override suspend fun deleteFavorite(userId: Int, foodId: Int) {
        favoriteDao.deleteFavorite(userId, foodId)
    }

}