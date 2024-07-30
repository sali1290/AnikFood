package com.sali.anikfood.domain.usecase.user

import com.sali.anikfood.data.entity.User
import com.sali.anikfood.domain.repo.UserRepo
import javax.inject.Inject

class DeleteUser @Inject constructor(private val userRepo: UserRepo){
    suspend fun invoke(user: User) = userRepo.deleteUser(user)
}