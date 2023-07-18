package com.pancake.pizza.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.pancake.pizza.ui.composable.AppBar
import com.pancake.pizza.ui.composable.PizzaViewPager

@Composable
fun PizzaScreen(
    modifier: Modifier = Modifier,
    viewModel: PizzaViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    PizzaContent(
        modifier = modifier,
        state = state,
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PizzaContent(
    modifier: Modifier = Modifier,
    state: PizzaUIState
) {
    val pagerState = rememberPagerState()

    LazyColumn(
        modifier = modifier,
    ) {
        item {
            PizzaViewPager(
                state = state,
                pagerState = pagerState,
            )
        }
        // sizes button
        item {

        }
    }

}

@Preview
@Composable
fun PreviewPizzaContent(viewModel: PizzaViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    PizzaContent(state = state)

}
