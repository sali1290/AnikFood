package com.sali.anikfood.app.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sali.anikfood.app.screen.AddDataScreen
import com.sali.anikfood.app.screen.MainScreen

@Composable
fun AnikFoodNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route,
        modifier = modifier
    ) {

        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }

        composable(route = Screen.AddDataScreen.route) {
            AddDataScreen()
        }

    }

}

sealed class Screen(val route: String) {

    data object MainScreen : Screen(route = "MainScreen")

    data object AddDataScreen : Screen(route = "AddDataScreen")

}