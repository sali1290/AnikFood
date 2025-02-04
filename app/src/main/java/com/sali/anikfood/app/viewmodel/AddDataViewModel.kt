package com.sali.anikfood.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sali.anikfood.domain.model.FoodModel
import com.sali.anikfood.domain.model.UserModel
import com.sali.anikfood.domain.usecase.food.AddFood
import com.sali.anikfood.domain.usecase.user.AddUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddDataViewModel @Inject constructor(
    private val addUser: dagger.Lazy<AddUser>,
    private val addFood: dagger.Lazy<AddFood>
) : ViewModel() {

    fun addUser(userName: String) = viewModelScope.launch(Dispatchers.IO) {
        addUser.get().invoke(UserModel(userId = 0, userName = userName))
    }

    fun addFood(foodName: String) = viewModelScope.launch(Dispatchers.IO) {
        addFood.get().invoke(FoodModel(foodId = 0, foodName = foodName))
    }

}