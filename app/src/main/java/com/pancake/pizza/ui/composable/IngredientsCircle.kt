package com.pancake.pizza.ui.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.pancake.pizza.R

@Composable
fun IngredientsCircle(
    modifier: Modifier = Modifier,
    badgeNumber: Int = 0,
    circleTint: Color
) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Circle(tint = circleTint, circleSize = 20f)
        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_foreground,),
            contentDescription = ""
        )
    }
}