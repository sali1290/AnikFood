package com.sali.anikfood.data.mapper

import com.sali.anikfood.data.entity.User
import com.sali.anikfood.domain.model.UserModel
import javax.inject.Inject

class UserMapper @Inject constructor() {

    fun convertUserToUserModel(user: User): UserModel {
        return UserModel(userId = user.userId, userName = user.userName)
    }

    fun convertUserModelToUsers(userModel: UserModel): User {
        return User(userId = userModel.userId, userName = userModel.userName)
    }


}