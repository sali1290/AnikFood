package com.sali.anikfood.app.viewmodel

import androidx.lifecycle.ViewModel
import com.sali.anikfood.domain.usecase.favorite.AddFavorite
import com.sali.anikfood.domain.usecase.favorite.DeleteFavorite
import com.sali.anikfood.domain.usecase.favorite.GetUserFavorites
import com.sali.anikfood.domain.usecase.food.DeleteFood
import com.sali.anikfood.domain.usecase.food.GetAllFoods
import com.sali.anikfood.domain.usecase.food.GetUserFavoriteFoods
import com.sali.anikfood.domain.usecase.user.DeleteUser
import com.sali.anikfood.domain.usecase.user.GetAllUsers
import com.sali.anikfood.domain.usecase.user.GetUser
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllUsers: GetAllUsers,
    private val getUser: dagger.Lazy<GetUser>,
    private val getAllFoods: GetAllFoods,
    private val deleteUser: dagger.Lazy<DeleteUser>,
    private val deleteFood: dagger.Lazy<DeleteFood>,
    private val getUserFavorites: dagger.Lazy<GetUserFavorites>,
    private val getUserFavoriteFoods: dagger.Lazy<GetUserFavoriteFoods>,
    private val addFavorite: dagger.Lazy<AddFavorite>,
    private val deleteFavorite: dagger.Lazy<DeleteFavorite>,
) : ViewModel() {
}