package com.pancake.pizza.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.pancake.pizza.R
import com.pancake.pizza.ui.screens.PizzaUIState

// todo 2

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PizzaViewPager(
    state: PizzaUIState,
    pagerState: PagerState,
) {


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.5f),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            modifier = Modifier
                .align(Alignment.Center)
                .size(250.dp),
            painter = painterResource(id = R.drawable.plate),
            contentDescription = null,
        )

        // the view pager here
        HorizontalPager(
            modifier = Modifier.align(Alignment.Center),
            count = 5,
            state = pagerState,

            ) { pizza ->
            Image(
                modifier = Modifier.size(state.size),
                painter = painterResource(id = state.pizzaList[pizza]),
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
fun PreviewPizzaViewPager() {

}