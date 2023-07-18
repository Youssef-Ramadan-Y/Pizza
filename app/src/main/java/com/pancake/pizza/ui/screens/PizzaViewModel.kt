package com.pancake.pizza.ui.screens

import androidx.lifecycle.ViewModel
import com.pancake.pizza.R
import com.pancake.pizza.ui.screens.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PizzaViewModel @Inject constructor() : BaseViewModel<PizzaUIState>(PizzaUIState()) {

    val pizzaList = listOf(
        R.drawable.bread_1,
        R.drawable.bread_2,
        R.drawable.bread_3,
        R.drawable.bread_4,
        R.drawable.bread_5,
    )

    init {
        get()
    }

    fun get() {
        updateState { it.copy(pizzaList = pizzaList) }
    }


}