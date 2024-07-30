package com.sali.anikfood.domain.repo

import com.sali.anikfood.data.entity.User

interface UserRepo {

    suspend fun getAllUsers(): List<User>

    suspend fun getUser(userId: Int): User

    suspend fun addUser(user: User)

    suspend fun deleteUser(user: User)

}