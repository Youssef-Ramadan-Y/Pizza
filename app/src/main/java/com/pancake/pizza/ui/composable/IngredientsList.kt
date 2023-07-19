package com.pancake.pizza.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.pancake.pizza.ui.screens.Ingredients
import com.pancake.pizza.ui.screens.OrderUiState

@Composable
fun IngredientsList(
    state: OrderUiState,
    onIngredientSelected: (id: Int, item: Ingredients) -> Unit,
) {

    val selectedItems = remember {
        mutableStateListOf<Int>()
    }

    LazyRow(
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        itemsIndexed(state.ingredients) { index, item: Ingredients ->
            IngredientsCircle(
                state = item,
                isSelected = selectedItems.contains(index),
                onClick = {
                    if (selectedItems.contains(index)) {
                        selectedItems.remove(index)
                    } else {
                        selectedItems.add(index)
                    }
                    onIngredientSelected(index, item)
                })
        }

    }

}