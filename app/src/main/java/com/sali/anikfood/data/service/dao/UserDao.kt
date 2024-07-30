package com.sali.anikfood.data.service.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sali.anikfood.data.entity.User

@Dao
interface UserDao {

    @Insert
    fun addUser(user: User)

    @Query("SELECT * FROM users")
    fun getAllUsers(): List<User>

    @Query("SELECT * FROM users WHERE user_id LIKE :userId LIMIT 1")
    fun getUser(userId: Int): User

    @Delete
    fun deleteUser(user: User)

}