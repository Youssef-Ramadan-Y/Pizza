package com.pancake.pizza

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pancake.pizza.ui.composable.AppBar
import com.pancake.pizza.ui.screens.PizzaScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PizzaApp() {

    Scaffold(
        topBar = {
            AppBar(
                modifier = Modifier.fillMaxWidth()
            )

        }
    ) { padding ->
        PizzaScreen(modifier = Modifier.padding(padding))
    }

}