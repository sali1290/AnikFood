package com.sali.anikfood.app.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.sali.anikfood.R
import com.sali.anikfood.app.component.AddDataCard
import com.sali.anikfood.app.viewmodel.AddDataViewModel

@Composable
fun AddDataScreen(addDataViewModel: AddDataViewModel = hiltViewModel()) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            var userName by remember { mutableStateOf("") }
            AddDataCard(
                title = stringResource(R.string.add_user),
                hintText = stringResource(R.string.enter_user_name),
                text = userName,
                onTextChange = { userName = it }
            ) {
                addDataViewModel.addUser(userName)
            }

            var foodName by remember { mutableStateOf("") }
            AddDataCard(
                title = stringResource(R.string.add_food),
                hintText = stringResource(R.string.enter_food_name),
                text = foodName,
                onTextChange = { foodName = it }
            ) {
                addDataViewModel.addFood(foodName)
            }
        }

    }
}