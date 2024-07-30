package com.sali.anikfood.data.service.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sali.anikfood.data.entity.Food

@Dao
interface FoodDao {

    @Query("SELECT * FROM foods")
    fun getAllFoods(): List<Food>

    @Query("SELECT * FROM foods WHERE food_id IN (:foodIds)")
    fun getFoodsByIds(foodIds: List<Int>): List<Food>

    @Insert
    fun addFood(food: Food)

    @Delete
    fun deleteFood(food: Food)

}