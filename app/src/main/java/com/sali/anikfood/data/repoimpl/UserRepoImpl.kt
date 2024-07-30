package com.sali.anikfood.data.repoimpl

import com.sali.anikfood.data.entity.User
import com.sali.anikfood.data.service.dao.UserDao
import com.sali.anikfood.domain.repo.UserRepo
import javax.inject.Inject

class UserRepoImpl @Inject constructor(private val userDao: UserDao) : UserRepo {
    override suspend fun getAllUsers(): List<User> {
        return userDao.getAllUsers()
    }

    override suspend fun getUser(userId: Int): User {
        return userDao.getUser(userId)
    }

    override suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

    override suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }
}