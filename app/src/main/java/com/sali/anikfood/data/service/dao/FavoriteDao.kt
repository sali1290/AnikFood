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

    @Update
    fun updateFavorite(favorite: Favorite)

    @Query("SELECT * FROM favorites")
    fun getAllFavorites(): List<Favorite>

    @Delete
    fun deleteFavorite(favorite: Favorite)

}