package com.pancake.pizza.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.pancake.pizza.R


// todo 1

@Composable
fun PizzaItem(
    // should pass the state changed
) {

    Image(
        modifier = Modifier.size(10.dp),
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = null
    )

}