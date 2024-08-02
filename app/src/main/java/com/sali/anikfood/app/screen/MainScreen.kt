package com.sali.anikfood.app.screen

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.sali.anikfood.R
import com.sali.anikfood.app.component.CustomFloatingActionButton
import com.sali.anikfood.app.component.FoodItem
import com.sali.anikfood.app.component.FoodType
import com.sali.anikfood.app.component.Screen
import com.sali.anikfood.app.component.TextFieldWithDropdownMenu
import com.sali.anikfood.app.viewmodel.MainViewModel
import com.sali.anikfood.domain.model.FavoriteModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(navController: NavController, mainViewModel: MainViewModel = hiltViewModel()) {

    val allUsersState by mainViewModel.allUsers.collectAsStateWithLifecycle()
    val foodState by mainViewModel.allFoods.collectAsStateWithLifecycle()
    val userState by mainViewModel.user.collectAsStateWithLifecycle()
    val userFavoritesState by mainViewModel.userFavorites.collectAsStateWithLifecycle()
    val userFavoriteFoodsState by mainViewModel.userFavoriteFoods.collectAsStateWithLifecycle()
    LaunchedEffect(key1 = Unit) {
        mainViewModel.apply {
            getAllUsers()
            getAllFoods()
        }
    }
    LaunchedEffect(key1 = userFavoritesState) {
        mainViewModel.getUserFavoriteFoods(userFavoritesState.map { it.foodId })
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
                listItems = allUsersState
            ) { userId ->
                mainViewModel.apply {
                    getUser(userId)
                    getUserFavorites(userId)
                    getUserFavoriteFoods(userFavoritesState.map { it.favoriteId })
                }
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
                when {
                    userState == null -> {
                        ListError(text = stringResource(R.string.please_choose_a_user))
                    }

                    foodState.isEmpty() -> {
                        ListError(text = stringResource(R.string.please_insert_some_foods_to_start))
                    }

                    else -> {
                        when (page) {
                            0 -> {
                                LazyColumn(modifier = Modifier.fillMaxSize()) {
                                    items(foodState) { item ->
                                        FoodItem(
                                            name = item.foodName,
                                            isFavorite = userFavoriteFoodsState.contains(item),
                                            onLikeClick = {
                                                mainViewModel.addFavorite(
                                                    userState!!.userId,
                                                    FavoriteModel(
                                                        favoriteId = 0,
                                                        userId = userState?.userId!!,
                                                        foodId = item.foodId
                                                    )
                                                )
                                            },
                                            onDeleteClick = {
                                                mainViewModel.deleteFood(item)
                                            })
                                    }
                                }
                            }

                            1 -> {
                                LazyColumn(modifier = Modifier.fillMaxSize()) {
                                    items(userFavoriteFoodsState) { item ->
                                        FoodItem(
                                            name = item.foodName,
                                            isFavorite = true,
                                            onLikeClick = {
                                                mainViewModel.deleteFavorite(
                                                    userState?.userId!!,
                                                    foodId = item.foodId
                                                )
                                            },
                                            onDeleteClick = { mainViewModel.deleteFood(item) })
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ListError(text: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text)
    }
}
