package com.pancake.pizza.ui.screens

import com.pancake.pizza.util.PizzaSizes


data class OrderUiState(
    val pizzaList: List<Pizza> = emptyList(),
    val ingredients: List<Ingredients> = emptyList(),
    val currentPage: Int = 0,
)

data class Pizza(
    val id: Int = 0,
    val pizzaSize: PizzaSizes = PizzaSizes.Medium,
    val image: Int = 0,
    val hasIngredients: Boolean = false,
    val ingredients: List<Ingredients> = emptyList(),

    )

data class Ingredients(
    val id: Int = 0,
    val icon: Int = 0,
    val image: Int = 0,
    val isSelected: Boolean = false,
)
