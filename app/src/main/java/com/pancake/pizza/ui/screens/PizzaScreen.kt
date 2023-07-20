package com.pancake.pizza.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.pancake.pizza.R
import com.pancake.pizza.ui.composable.IconButton
import com.pancake.pizza.ui.composable.IngredientsList
import com.pancake.pizza.ui.composable.PizzaSizeButtons
import com.pancake.pizza.ui.composable.PizzaViewPager
import com.pancake.pizza.ui.theme.Gray
import com.pancake.pizza.util.PizzaSizes

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
        onSmallClicked = { viewModel.onChangePizzaSize(pagerState.currentPage, PizzaSizes.Small) },
        onMediumClicked = { viewModel.onChangePizzaSize(pagerState.currentPage, PizzaSizes.Medium) },
        onLargeClicked = { viewModel.onChangePizzaSize(pagerState.currentPage, PizzaSizes.Large) },
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
    onSelectIngredients: (ingredientsId: Int, pizzaPosition: Int) -> Unit,
) {
    Column(modifier = modifier.fillMaxSize()) {

        PizzaViewPager(
            state = state,
            pagerState = pagerState,
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "$17",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
        )
        Spacer(modifier = Modifier.height(32.dp))
        PizzaSizeButtons(
            pagerState = pagerState.currentPage,
            state = state,
            onLargeClicked = onLargeClicked,
            onMediumClicked = onMediumClicked,
            onSmallClicked = onSmallClicked,
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            text = "Customize your pizza",
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = Gray,
        )

        IngredientsList(
            state = state,
            pagerState = pagerState.currentPage,
            onIngredientSelected = { id, pageState -> onSelectIngredients(id, pageState) },
        )

        Spacer(modifier = Modifier.weight(1f))

        IconButton(
            stringId = R.string.add_to_cart,
            modifier = Modifier
                .padding(bottom = 56.dp)
                .align(Alignment.CenterHorizontally),
        ) {

        }


    }
}

