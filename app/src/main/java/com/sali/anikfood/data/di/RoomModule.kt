package com.sali.anikfood.data.di

import android.content.Context
import androidx.room.Room
import com.sali.anikfood.data.service.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Singleton
    @Provides
    fun provideRoomDB(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "AnikFood-db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideUserDao(appDatabase: AppDatabase) = appDatabase.userDao()

    @Provides
    @Singleton
    fun provideFoodDao(appDatabase: AppDatabase) = appDatabase.foodDao()

    @Provides
    @Singleton
    fun provideFavoriteDao(appDatabase: AppDatabase) = appDatabase.favoriteDao()
}