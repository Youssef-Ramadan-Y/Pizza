package com.pancake.pizza.ui.screens

import com.pancake.pizza.util.DataStore.pizzaList
import com.pancake.pizza.util.DataStore.pizzaIngredients
import com.pancake.pizza.ui.screens.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PizzaViewModel @Inject constructor() : BaseViewModel<OrderUiState>(OrderUiState()) {

    init {
        updateState {
            it.copy(
                pizzaList = pizzaList(),
                ingredients = pizzaIngredients(),
            )
        }
    }

    fun onChangePizzaSize(position: Int, newSize: Float) {
        updatePizzaSize(position, newSize)
    }

    private fun updatePizzaSize(position: Int, newSize: Float) {
        updateState { currentState ->
            currentState.copy(
                pizzaList = currentState.pizzaList.map { pizza ->
                    if (pizza == currentState.pizzaList[position]) pizza.copy(pizzaSize = newSize) else pizza
                }
            )
        }
    }

    fun onIngredientsClick(ingredientsPosition: Int, pizzaPosition: Int, item: Ingredients) {
        val currentPizzaList = state.value.pizzaList.toMutableList()
        val currentPizza = currentPizzaList[pizzaPosition]
        val currentIngredients = currentPizza.ingredients.toMutableList()
        val existingIngredientIndex = currentIngredients.indexOfFirst { it.id == item.id }
        if (existingIngredientIndex != -1) {
            // Ingredient exists in the pizza, remove it and set isSelected to false
            currentIngredients.removeAt(existingIngredientIndex)
        } else {
            // Ingredient does not exist in the pizza, add it and set isSelected to true
            currentIngredients.add(item)
        }
        currentPizzaList[pizzaPosition] = currentPizza.copy(ingredients = currentIngredients)
        updateState { currentState ->
            currentState.copy(pizzaList = currentPizzaList)
        }
    }
}