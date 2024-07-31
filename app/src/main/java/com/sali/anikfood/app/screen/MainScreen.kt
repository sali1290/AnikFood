package com.sali.anikfood.app.screen

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.sali.anikfood.R
import com.sali.anikfood.app.component.CustomFloatingActionButton
import com.sali.anikfood.app.component.FoodType
import com.sali.anikfood.app.component.Screen
import com.sali.anikfood.app.component.TextFieldWithDropdownMenu
import com.sali.anikfood.app.viewmodel.MainViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(navController: NavController, mainViewModel: MainViewModel = hiltViewModel()) {

    val allUsersState = mainViewModel.allUsers.collectAsStateWithLifecycle()
//    val foodState = mainViewModel.allFoods.collectAsStateWithLifecycle()
//    val userState = mainViewModel.user.collectAsStateWithLifecycle()
    LaunchedEffect(key1 = Unit) {
        mainViewModel.getAllUsers()
        mainViewModel.getAllFoods()
    }

    val pagerState = rememberPagerState(initialPage = 0, pageCount = { 2 })
    val coroutineScope = rememberCoroutineScope()

    Scaffold(modifier = Modifier.fillMaxSize(), floatingActionButton = {
        CustomFloatingActionButton { navController.navigate(Screen.AddDataScreen.route) }
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            TextFieldWithDropdownMenu(
                listItems = allUsersState.value
            ) { userId ->
                mainViewModel.getUser(userId)
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                FoodType(
                    modifier = Modifier.weight(0.33f),
                    text = stringResource(R.string.all_foods),
                    enabled = pagerState.currentPage == 0
                ) {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(0, animationSpec = tween(500))
                    }
                }

                FoodType(
                    modifier = Modifier.weight(0.33f),
                    text = stringResource(R.string.favorite_foods),
                    enabled = pagerState.currentPage == 1
                ) {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(1, animationSpec = tween(500))
                    }
                }
            }

            HorizontalPager(state = pagerState) { page ->
                when (page) {
                    0 -> {
                        Text(text = "0")
                    }

                    1 -> {
                        Text(text = "1")
                    }
                }
            }

        }

    }

}