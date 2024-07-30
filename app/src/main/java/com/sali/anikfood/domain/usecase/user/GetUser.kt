package com.sali.anikfood.domain.usecase.user

import com.sali.anikfood.domain.repo.UserRepo
import javax.inject.Inject

class GetUser @Inject constructor(private val userRepo: UserRepo) {
    suspend fun invoke(userId: Int) = userRepo.getUser(userId)
}