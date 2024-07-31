package com.sali.anikfood.app.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sali.anikfood.R

@Composable
fun TextFieldWithDropdownMenu(
    listItems: List<String>,
    onMenuItemClick: (String) -> Unit
) {
    var selectedItem by remember { mutableStateOf("") }
    var menuExpanded by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .border(
                width = 2.dp,
                color = FloatingActionButtonDefaults.containerColor,
                shape = RoundedCornerShape(size = 10.dp)
            )
            .clickable { menuExpanded = true },
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = selectedItem.ifEmpty { stringResource(R.string.choose_a_user) },
            color = if (selectedItem.isEmpty()) Color.Gray else Color.Black,
            modifier = Modifier.padding(10.dp),
            fontSize = 18.sp
        )

        DropdownMenu(
            expanded = menuExpanded,
            onDismissRequest = { menuExpanded = false }
        ) {
            listItems.forEach { item ->
                DropdownMenuItem(
                    onClick = {
                        selectedItem = item
                        onMenuItemClick(item)
                    },
                    text = { Text(text = item) }
                )
            }
        }
    }


}