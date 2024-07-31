package com.sali.anikfood.app.viewmodel

import androidx.lifecycle.ViewModel
import com.sali.anikfood.domain.usecase.food.AddFood
import com.sali.anikfood.domain.usecase.user.AddUser
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddDataViewModel @Inject constructor(
    private val addUser: dagger.Lazy<AddUser>,
    private val addFood: dagger.Lazy<AddFood>
) : ViewModel() {
}