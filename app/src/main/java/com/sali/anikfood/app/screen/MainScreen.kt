package com.sali.anikfood.app.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.sali.anikfood.app.component.CustomFloatingActionButton
import com.sali.anikfood.app.component.Screen

@Composable
fun MainScreen(navController: NavController) {

    Scaffold(modifier = Modifier.fillMaxSize(), floatingActionButton = {
        CustomFloatingActionButton { navController.navigate(Screen.AddDataScreen.route) }
    }) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Text(text = "MainScreen")
        }
    }

}