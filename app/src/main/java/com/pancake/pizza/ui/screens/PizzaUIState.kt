package com.pancake.pizza.ui.screens


data class OrderUiState(
    val pizzaList: List<Pizza> = emptyList(),
    val ingredients: List<Ingredients> = emptyList(),
)

data class Pizza(
    val id: Int = 0,
    val pizzaSize: Float = 200f,
    val image: Int = 0,
    val ingredients: List<Ingredients> = emptyList(),
)

data class Ingredients(
    val id: Int = 0,
    val icon: Int = 0,
    val image: Int = 0,
    val isSelected: Boolean = false,
)
