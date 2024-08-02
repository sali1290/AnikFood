package com.sali.anikfood.app.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sali.anikfood.R

@Composable
fun FoodItem(name: String, onLikeClick: () -> Unit, onDeleteClick: () -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(modifier = Modifier.weight(0.9f), verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_food),
                    contentDescription = stringResource(R.string.food)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = name, fontSize = 18.sp)
            }
            Row(modifier = Modifier.weight(0.2f)) {
                Image(
                    modifier = Modifier
                        .weight(0.5f)
                        .clickable { onLikeClick.invoke() },
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = stringResource(R.string.liked)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Image(
                    modifier = Modifier
                        .weight(0.5f)
                        .clickable { onDeleteClick.invoke() },
                    imageVector = Icons.Default.Delete,
                    contentDescription = stringResource(R.string.delete)
                )
            }
        }
    }

}