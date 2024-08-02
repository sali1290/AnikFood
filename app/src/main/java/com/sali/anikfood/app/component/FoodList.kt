package com.sali.anikfood.app.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.sali.anikfood.R
import com.sali.anikfood.domain.model.FoodModel

@Composable
fun FoodList(foodList: List<FoodModel>, onDeleteItemClick: (FoodModel) -> Unit) {

    if (foodList.isNotEmpty()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(foodList) { item ->
                FoodItem(name = item.foodName) {
                    onDeleteItemClick(item)
                }
            }
        }
    } else {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = stringResource(R.string.please_insert_some_foods_to_start))
        }
    }

}