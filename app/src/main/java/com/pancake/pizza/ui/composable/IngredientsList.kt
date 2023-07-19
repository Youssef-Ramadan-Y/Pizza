package com.pancake.pizza.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.pancake.pizza.ui.screens.Ingredients
import com.pancake.pizza.ui.screens.OrderUiState

@Composable
fun IngredientsList(
    state: OrderUiState,
    pagerState: Int,
    onIngredientSelected: (id:Int, pageState:Int) -> Unit,
) {

    LazyRow(
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        itemsIndexed(state.pizzaList[pagerState].ingredients) { index, item: Ingredients ->
            IngredientsCircle(
                state = item,
                isSelected = item.isSelected,
                onClick = {
                    onIngredientSelected(index,pagerState)
                })
        }

    }

}