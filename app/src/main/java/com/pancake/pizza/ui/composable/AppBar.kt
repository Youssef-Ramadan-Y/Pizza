package com.pancake.pizza.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.pancake.pizza.R

@Composable
fun AppBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(vertical = 8.dp, horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {

        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "",
        )
        Text(text = "Pizza")
        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "",
        )


    }

}