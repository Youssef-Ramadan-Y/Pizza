package com.pancake.pizza.ui.screens

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class PizzaUIState(
    val pizzaList: List<Int> = emptyList(),      //
    val size: Dp = 220.dp,
)