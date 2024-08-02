package com.sali.anikfood.data.mapper

import com.sali.anikfood.data.entity.Favorite
import com.sali.anikfood.domain.model.FavoriteModel
import javax.inject.Inject

class FavoriteMapper @Inject constructor(){

    fun convertFavoriteToFavoriteModel(favorite: Favorite): FavoriteModel {
        return FavoriteModel(
            favoriteId = favorite.favoriteId,
            userId = favorite.userId,
            foodId = favorite.foodId
        )
    }

    fun convertFavoriteModelToFavorite(favoriteModel: FavoriteModel): Favorite {
        return Favorite(
            favoriteId = favoriteModel.favoriteId,
            userId = favoriteModel.userId,
            foodId = favoriteModel.foodId
        )
    }

}