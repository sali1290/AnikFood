package com.sali.anikfood.data.repoimpl

import com.sali.anikfood.data.entity.User
import com.sali.anikfood.domain.repo.UserRepo
import javax.inject.Inject

class UserRepoImpl @Inject constructor(): UserRepo {
    override suspend fun getAllUsers(): List<User> {
        TODO("Not yet implemented")
    }

    override suspend fun getUser(userId: Int): User {
        TODO("Not yet implemented")
    }

    override suspend fun addUser(user: User) {
        TODO("Not yet implemented")
    }

    override suspend fun updateUser(user: User) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteUser(user: User) {
        TODO("Not yet implemented")
    }
}