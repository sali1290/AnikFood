package com.sali.anikfood.domain.repo

import com.sali.anikfood.domain.model.UserModel

interface UserRepo {

    suspend fun getAllUsers(): List<UserModel>

    suspend fun getUser(userId: Int): UserModel

    suspend fun addUser(userModel: UserModel)

    suspend fun deleteUser(userModel: UserModel)

}