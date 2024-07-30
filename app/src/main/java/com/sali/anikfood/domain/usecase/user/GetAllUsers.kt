package com.sali.anikfood.domain.usecase.user

import com.sali.anikfood.domain.repo.UserRepo
import javax.inject.Inject

class GetAllUsers @Inject constructor(private val userRepo: UserRepo){
    suspend fun invoke() = userRepo.getAllUsers()
}