package com.pancake.pizza.ui.composable

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun IngredientsList() {
    LazyRow() {
        items(10) {
            IngredientsCircle(circleTint = Color.White)
        }
    }

}