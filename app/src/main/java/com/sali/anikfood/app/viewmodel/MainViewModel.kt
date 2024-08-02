package com.sali.anikfood.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sali.anikfood.domain.model.FavoriteModel
import com.sali.anikfood.domain.model.FoodModel
import com.sali.anikfood.domain.model.UserModel
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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllUsers: GetAllUsers,
    private val getUser: dagger.Lazy<GetUser>,
    private val getAllFoods: GetAllFoods,
    private val getUserFavorites: dagger.Lazy<GetUserFavorites>,
    private val getUserFavoriteFoods: dagger.Lazy<GetUserFavoriteFoods>,
    private val deleteUser: dagger.Lazy<DeleteUser>,
    private val deleteFood: dagger.Lazy<DeleteFood>,
    private val addFavorite: dagger.Lazy<AddFavorite>,
    private val deleteFavorite: dagger.Lazy<DeleteFavorite>,
) : ViewModel() {

    private val _allUsers = MutableStateFlow<List<UserModel>>(emptyList())
    val allUsers get() = _allUsers.asStateFlow()
    fun getAllUsers() = viewModelScope.launch(Dispatchers.IO) {
        _allUsers.value = getAllUsers.invoke()
    }

    private val _user = MutableStateFlow<UserModel?>(null)
    val user get() = _user.asStateFlow()
    fun getUser(userId: Int) = viewModelScope.launch(Dispatchers.IO) {
        _user.value = getUser.get().invoke(userId)
    }

    private val _userFavorites = MutableStateFlow<List<FavoriteModel>>(emptyList())
    val userFavorites get() = _userFavorites.asStateFlow()
    fun getUserFavorites(userId: Int) = viewModelScope.launch(Dispatchers.IO) {
        _userFavorites.value = getUserFavorites.get().invoke(userId)
    }

    private val _userFavoriteFoods = MutableStateFlow<List<FoodModel>>(emptyList())
    val userFavoriteFoods get() = _userFavoriteFoods.asStateFlow()
    fun getUserFavoriteFoods(foodIds: List<Int>) = viewModelScope.launch(Dispatchers.IO) {
        _userFavoriteFoods.value = getUserFavoriteFoods.get().invoke(foodIds)
    }

    private val _allFoods = MutableStateFlow<List<FoodModel>>(emptyList())
    val allFoods get() = _allFoods.asStateFlow()
    fun getAllFoods() = viewModelScope.launch(Dispatchers.IO) {
        _allFoods.value = getAllFoods.invoke()
    }

    fun deleteUser(user: UserModel) = viewModelScope.launch(Dispatchers.IO) {
        deleteUser.get().invoke(user)
    }

    fun deleteFood(food: FoodModel) = viewModelScope.launch(Dispatchers.IO) {
        deleteFood.get().invoke(food)
        getAllFoods()
    }

    fun addFavorite(userId: Int, favorite: FavoriteModel) = viewModelScope.launch(Dispatchers.IO) {
        addFavorite.get().invoke(favorite)
        getUserFavorites(userId)
    }

    fun deleteFavorite(userId: Int, foodId: Int) = viewModelScope.launch(Dispatchers.IO) {
        deleteFavorite.get().invoke(userId, foodId)
        getUserFavorites(userId)
    }

}