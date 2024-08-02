package com.sali.anikfood.domain.usecase.user

import com.sali.anikfood.domain.model.UserModel
import com.sali.anikfood.domain.repo.UserRepo
import javax.inject.Inject

class DeleteUser @Inject constructor(private val userRepo: UserRepo){
    suspend fun invoke(userModel: UserModel) = userRepo.deleteUser(userModel)
}