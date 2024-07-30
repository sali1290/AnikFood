package com.sali.anikfood.data.service.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sali.anikfood.data.entity.Favorite

@Dao
interface FavoriteDao {

    @Insert
    fun addFavorite(favorite: Favorite)

    @Query("SELECT * FROM favorites WHERE user_id LIKE :userId LIMIT 1")
    fun getUserFavorites(userId: Int): List<Favorite>

    @Delete
    fun deleteFavorite(favorite: Favorite)

}