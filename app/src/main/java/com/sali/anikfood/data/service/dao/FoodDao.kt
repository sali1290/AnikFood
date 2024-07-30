package com.sali.anikfood.data.service.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sali.anikfood.data.entity.Food

@Dao
interface FoodDao {

    @Insert
    fun addFood(food: Food)

    @Update
    fun updateFood(food: Food)

    @Query("SELECT * FROM foods")
    fun getAllFoods(): List<Food>

    @Delete
    fun deleteFood(food: Food)

}