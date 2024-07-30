package com.sali.anikfood.data.service.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sali.anikfood.data.entity.Favorite
import com.sali.anikfood.data.entity.Food
import com.sali.anikfood.data.entity.User
import com.sali.anikfood.data.service.dao.FavoriteDao
import com.sali.anikfood.data.service.dao.FoodDao
import com.sali.anikfood.data.service.dao.UserDao

@Database(entities = [User::class, Food::class, Favorite::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun foodDao(): FoodDao

    abstract fun favoriteDao(): FavoriteDao

}