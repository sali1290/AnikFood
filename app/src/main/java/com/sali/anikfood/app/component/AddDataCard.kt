package com.sali.anikfood.app.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sali.anikfood.R

@Composable
fun AddDataCard(
    title: String,
    hintText: String,
    text: String,
    onTextChange: (String) -> Unit,
    onSaveClicked: () -> Unit
) {
    var isCardOpen by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(size = 15.dp),
        elevation = CardDefaults.cardElevation(15.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { isCardOpen = !isCardOpen }
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = title, fontSize = 18.sp)
            Icon(
                imageVector = if (isCardOpen)
                    Icons.Default.KeyboardArrowUp
                else
                    Icons.Default.ArrowDropDown,
                contentDescription = stringResource(R.string.arrow_down_or_up_icon)
            )
        }

        AnimatedVisibility(visible = isCardOpen) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                OutlinedTextField(
                    value = text,
                    onValueChange = onTextChange,
                    placeholder = { Text(text = hintText) },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    Button(onClick = onSaveClicked, enabled = text.isNotEmpty()) {
                        Text(text = stringResource(R.string.save))
                    }
                }
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun AddDataCardPreview() {
    AddDataCard("Add user", "Enter user name", "", {}) {}
}