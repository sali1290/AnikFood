package com.sali.anikfood.data.repoimpl

import com.sali.anikfood.data.mapper.UserMapper
import com.sali.anikfood.data.service.dao.UserDao
import com.sali.anikfood.domain.model.UserModel
import com.sali.anikfood.domain.repo.UserRepo
import javax.inject.Inject

class UserRepoImpl @Inject constructor(
    private val userDao: UserDao,
    private val mapper: UserMapper
) : UserRepo {
    override suspend fun getAllUsers(): List<UserModel> {
        return userDao.getAllUsers().map { mapper.convertUserToUserModel(it) }
    }

    override suspend fun getUser(userId: Int): UserModel {
        return mapper.convertUserToUserModel(userDao.getUser(userId))
    }

    override suspend fun addUser(userModel: UserModel) {
        val user = mapper.convertUserModelToUsers(userModel)
        userDao.addUser(user)
    }

    override suspend fun deleteUser(userModel: UserModel) {
        val user = mapper.convertUserModelToUsers(userModel)
        userDao.deleteUser(user)
    }
}