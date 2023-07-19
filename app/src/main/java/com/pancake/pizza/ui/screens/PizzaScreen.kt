package com.pancake.pizza.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.pancake.pizza.ui.composable.IngredientsList
import com.pancake.pizza.ui.composable.PizzaSizeButtons
import com.pancake.pizza.ui.composable.PizzaViewPager

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PizzaScreen(
    modifier: Modifier = Modifier,
    viewModel: PizzaViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    val pagerState = rememberPagerState()

    PizzaContent(
        modifier = modifier,
        pagerState = pagerState,
        state = state,
        onSmallClicked = { viewModel.onChangePizzaSize(pagerState.currentPage, 180f)},
        onMediumClicked = {viewModel.onChangePizzaSize(pagerState.currentPage, 200f)},
        onLargeClicked = { viewModel.onChangePizzaSize(pagerState.currentPage, 220f)},
        onSelectIngredients = viewModel::onIngredientsClick
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PizzaContent(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    state: OrderUiState,
    onSmallClicked: () -> Unit,
    onMediumClicked: () -> Unit,
    onLargeClicked: () -> Unit,
    onSelectIngredients: (ingredientsId: Int, pizzaPosition:Int, ingredient: Ingredients) -> Unit,
) {

    LazyColumn(
        modifier = modifier,
    ) {
        item {
            PizzaViewPager(
                state = state,
                pagerState = pagerState,
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "$17",
                style = MaterialTheme.typography.bodyLarge.copy(
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp
                )
            )
        }
        // sizes button
        item {
            PizzaSizeButtons(
                state = state,
                onLargeClicked = onLargeClicked,
                onMediumClicked = onMediumClicked,
                onSmallClicked = onSmallClicked,
            )
        }
        item {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                text = "Customize your pizza",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            )
            IngredientsList(
                state = state,
                onIngredientSelected = {id,item -> onSelectIngredients(id,pagerState.currentPage, item)},
            )
        }
    }
}

