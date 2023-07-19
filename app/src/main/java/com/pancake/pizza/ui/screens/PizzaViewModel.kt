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
            )
        }
        updateState {
            it.copy(pizzaList = it.pizzaList.map {
                it.copy(ingredients = pizzaIngredients())
            })
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

    fun onIngredientsClick(ingredientsPosition: Int, pizzaPosition: Int) {
        updateState {
            it.copy(
                it.pizzaList.mapIndexed { pizzaIndex, pizza ->
                    if (pizzaIndex == pizzaPosition) {
                        pizza.copy(
                            ingredients = pizza.ingredients.mapIndexed { index, ingredient ->
                                if (index == ingredientsPosition) {
                                    ingredient.copy(isSelected = !ingredient.isSelected)
                                } else {
                                    ingredient.copy(isSelected = ingredient.isSelected)
                                }
                            },
                        )
                    } else {
                        pizza.copy(
                            ingredients = pizza.ingredients.mapIndexed { index, ingredients ->
                                ingredients.copy(isSelected = ingredients.isSelected)
                            },
                        )
                    }
                },
                currentPage = pizzaPosition,
            )
        }
        // see if it has ingredients
        updateState {
            it.copy(pizzaList = it.pizzaList.mapIndexed { pizzaIndex, pizza ->
                if (pizza.ingredients.isEmpty()) {
                    pizza.copy(hasIngredients = false)
                } else {
                    pizza.copy(hasIngredients = true)
                }
            })
        }

    }
}