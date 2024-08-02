package com.sali.anikfood.data.service.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.sali.anikfood.data.entity.Favorite

@Dao
interface FavoriteDao {

    @Insert
    fun addFavorite(favorite: Favorite)

    @Query("SELECT * FROM favorites WHERE user_id LIKE :userId")
    fun getUserFavorites(userId: Int): List<Favorite>

    @Query("DELETE FROM favorites WHERE user_id LIKE :userId AND food_id LIKE :foodId")
    fun deleteFavorite(userId: Int, foodId: Int)

}