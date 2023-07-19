package com.pancake.pizza.util

import com.pancake.pizza.R
import com.pancake.pizza.ui.screens.Ingredients
import com.pancake.pizza.ui.screens.Pizza


object DataStore {

    fun pizzaList() = listOf(
        Pizza(id = 0, image = R.drawable.bread_1),
        Pizza(id = 1, image = R.drawable.bread_2),
        Pizza(id = 2, image = R.drawable.bread_3),
        Pizza(id = 3, image = R.drawable.bread_4),
        Pizza(id = 4, image = R.drawable.bread_5)
    )

    fun pizzaIngredients() = listOf(
        Ingredients(id = 0, icon = R.drawable.ic_basil, image = R.drawable.basil),
        Ingredients(id = 1, icon = R.drawable.ic_onion, image = R.drawable.onion),
        Ingredients(id = 2, icon = R.drawable.ic_mushroom, image = R.drawable.mushroom),
        Ingredients(id = 3, icon = R.drawable.ic_broccoli, image = R.drawable.broccoli),
        Ingredients(id = 4, icon = R.drawable.ic_sausage, image = R.drawable.sausage),
    )
}
