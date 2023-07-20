package com.pancake.pizza.ui.screens

import com.pancake.pizza.util.DataStore.pizzaList
import com.pancake.pizza.util.DataStore.pizzaIngredients
import com.pancake.pizza.ui.screens.base.BaseViewModel
import com.pancake.pizza.util.PizzaSizes
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PizzaViewModel @Inject constructor() : BaseViewModel<OrderUiState>(OrderUiState()) {

    init {
        getData()
    }

    fun getData() {
        updateState {
            it.copy(
                pizzaList = pizzaList(),
            )
        }
        updateState {
            it.copy(pizzaList = it.pizzaList.map {
                it.copy(ingredients = pizzaIngredients())
            })
        }
    }

    fun onChangePizzaSize(position: Int, newSize: PizzaSizes) {
        updatePizzaSize(position, newSize)
    }

    private fun updatePizzaSize(position: Int, newSize: PizzaSizes) {
        updateState { currentState ->
            currentState.copy(
                pizzaList = currentState.pizzaList.map { pizza ->
                    if (pizza == currentState.pizzaList[position]) pizza.copy(pizzaSize = newSize) else pizza
                }
            )
        }
    }

    fun onIngredientsClick(ingredientsPosition: Int, pizzaPosition: Int) {
        updateState { currentState ->
            val updatedPizzaList = updateIngredients(currentState.pizzaList, pizzaPosition, ingredientsPosition)
            val updatedPizzaListWithIngredientsFlag = updateHasIngredientsFlag(updatedPizzaList)

            currentState.copy(pizzaList = updatedPizzaListWithIngredientsFlag, currentPage = pizzaPosition)
        }
    }

    private fun updateIngredients(pizzaList: List<Pizza>, pizzaPosition: Int, ingredientsPosition: Int): List<Pizza> {
        return pizzaList.mapIndexed { index, pizza ->
            if (index == pizzaPosition) {
                val updatedIngredients = pizza.ingredients.mapIndexed { ingredientIndex, ingredient ->
                    if (ingredientIndex == ingredientsPosition) {
                        ingredient.copy(isSelected = !ingredient.isSelected)
                    } else {
                        ingredient
                    }
                }
                pizza.copy(ingredients = updatedIngredients)
            } else {
                pizza
            }
        }
    }

    private fun updateHasIngredientsFlag(pizzaList: List<Pizza>): List<Pizza> {
        return pizzaList.map { pizza ->
            pizza.copy(hasIngredients = pizza.ingredients.isNotEmpty())
        }
    }


}