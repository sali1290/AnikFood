package com.sali.anikfood.data.di

import com.sali.anikfood.data.repoimpl.FavoriteRepoImpl
import com.sali.anikfood.data.repoimpl.FoodRepoImpl
import com.sali.anikfood.data.repoimpl.UserRepoImpl
import com.sali.anikfood.domain.repo.FavoriteRepo
import com.sali.anikfood.domain.repo.FoodRepo
import com.sali.anikfood.domain.repo.UserRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepoModule {

    @Binds
    @Singleton
    fun bindFoodRepo(foodRepoImpl: FoodRepoImpl): FoodRepo

    @Binds
    @Singleton
    fun bindUserRepo(userRepoImpl: UserRepoImpl): UserRepo

    @Binds
    @Singleton
    fun bindFavoriteRepo(favoriteRepoImpl: FavoriteRepoImpl): FavoriteRepo

}