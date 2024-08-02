package com.sali.anikfood.app.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.sali.anikfood.app.component.AnikFoodNavHost
import com.sali.anikfood.app.theme.AnikFoodTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnikFoodTheme {
                AnikFoodNavHost()
            }
        }
    }
}